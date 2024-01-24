package com.application.rest.SpringBootApiRest.controllers;

import com.application.rest.SpringBootApiRest.entities.Maker;
import com.application.rest.SpringBootApiRest.controllers.dto.MakerDTO;
import com.application.rest.SpringBootApiRest.services.MakerService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/maker")
public class MakerController {
    
    @Autowired
    private MakerService makerService;
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MakerDTO dto) throws URISyntaxException    {
        if(dto.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Maker must have a name.");
        }
        
        makerService.save(Maker.builder()
                    .name(dto.getName())
                    .build());
        
        return ResponseEntity.created(new URI("/maker/save")).build();
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)  {
        
            Optional<Maker> response = makerService.findById(id);
            
            if(response.isPresent())   {
                
                Maker maker = response.get();
                
                MakerDTO dto = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build();
                
                return ResponseEntity.ok(dto);
            }
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Maker not found.");
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()  {
        
        List<MakerDTO> makerList = makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .productList(maker.getProductList())
                    .build())
                .toList();
        
        return ResponseEntity.ok(makerList);
    }
    
}

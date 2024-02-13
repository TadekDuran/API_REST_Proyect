package com.application.rest.SpringBootApiRest.controllers;

import com.application.rest.SpringBootApiRest.controllers.dto.ProductDTO;
import com.application.rest.SpringBootApiRest.entities.Product;
import com.application.rest.SpringBootApiRest.services.ProductService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDto) throws URISyntaxException    {
        
        emptyChecker(productDto);
        
        Product product = Product.builder()
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .maker(productDto.getMaker())
                    .build();
              
        productService.save(product);
        
        return ResponseEntity.created(new URI("/product/save")).build();
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)  {

        Optional<Product> response = productService.findById(id);

        if(!response.isPresent())   {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found.");
        }

        Product product = response.get();

        ProductDTO dto = ProductDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .maker(product.getMaker())
            .build();

        return ResponseEntity.ok(dto);
    }
        
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll()  {

        List<ProductDTO> productList = productService.findAll()
            .stream()
            .map(product -> ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .maker(product.getMaker())
                .build())
            .toList();

        return ResponseEntity.ok(productList);
    }
    
    @PutMapping("/update/{id}")
        public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDto) {
            Optional<Product> response = productService.findById(id);

            if(!response.isPresent())   {
                return ResponseEntity.notFound().build();
            }

            Product product = response.get();
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setMaker(productDto.getMaker());
            productService.save(product);
            return ResponseEntity.ok("Product updated.");
        }
    
    @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteProduct(@PathVariable Long id)  {
            
            if(id == null)  {
                return ResponseEntity.badRequest().build();
            }
            
            productService.deleteById(id);
            return ResponseEntity.ok("Product eliminated.");
            
        }
    
    private void emptyChecker(ProductDTO productDto)    {
        if(productDto.getName().isBlank())   {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product must have a name.");
        }
        if(productDto.getPrice() == null)   {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product must have a price.");
        }
        if(productDto.getMaker() == null)   {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product must have a maker.");
        }
    }
}
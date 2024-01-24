package com.application.rest.SpringBootApiRest.persistence;

import com.application.rest.SpringBootApiRest.entities.Maker;
import com.application.rest.SpringBootApiRest.repositories.MakerRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakerDAO {
    
    @Autowired
    private MakerRepository makerRepo;
    
    public List<Maker> findAll()   {
        return (List<Maker>) makerRepo.findAll();
    }
    
    public Optional<Maker> findById(Long id)   {
        return makerRepo.findById(id);
    }
    
    public void save(Maker maker)  {
        makerRepo.save(maker);
    }
    
    public void deleteById(Long id)    {
        makerRepo.deleteById(id);
    }
    
}


package com.application.rest.SpringBootApiRest.services;

import com.application.rest.SpringBootApiRest.entities.Maker;
import com.application.rest.SpringBootApiRest.persistence.MakerDAO;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakerService {
    
    @Autowired
    private MakerDAO makerDAO;
    
    public List<Maker> findAll()   {
        return makerDAO.findAll();
    }
    
    public Optional<Maker> findById(Long id)   {
        return makerDAO.findById(id);
    }
    
    public void save(Maker maker)  {
        makerDAO.save(maker);
    }
    
    public void deleteById(Long id)    {
        makerDAO.deleteById(id);
    }
    
}

package com.application.rest.SpringBootApiRest.persistence.Impl;

import com.application.rest.SpringBootApiRest.entities.Maker;
import com.application.rest.SpringBootApiRest.persistence.IMakerDAO;
import com.application.rest.SpringBootApiRest.repositories.MakerRepository;
import com.application.rest.SpringBootApiRest.repositories.MakerRepository;
import java.util.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakerDAOImpl implements IMakerDAO {
    
    @Autowired
    private MakerRepository makerRepo;
    
    @Override
    public List<Maker> findAll() {
        return makerRepo.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepo.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepo.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepo.deleteById(id);
    }

    

}

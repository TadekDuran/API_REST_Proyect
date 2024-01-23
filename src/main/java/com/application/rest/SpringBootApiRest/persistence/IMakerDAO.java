package com.application.rest.SpringBootApiRest.persistence;

import com.application.rest.SpringBootApiRest.entities.Maker;
import java.util.*;

public interface IMakerDAO {
    
    List<Maker> findAll();
    
    Optional<Maker> findById(Long id);
    
    void save(Maker maker);
    
    void deleteById(Long id);
    
}

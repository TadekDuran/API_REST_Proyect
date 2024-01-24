package com.application.rest.SpringBootApiRest.repositories;

import com.application.rest.SpringBootApiRest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {
    
}

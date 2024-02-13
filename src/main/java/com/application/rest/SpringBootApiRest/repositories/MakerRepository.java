package com.application.rest.SpringBootApiRest.repositories;

import com.application.rest.SpringBootApiRest.entities.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long> {
    
}

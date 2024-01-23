package com.application.rest.SpringBootApiRest.repositories;

import com.application.rest.SpringBootApiRest.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findProductsByPriceInRange(@Param("minPrice")Double minPrice, @Param("maxPrice")Double maxPrice);
    
    @Query("SELECT p FROM Product p WHERE p.maker.id = :idMaker")
    List<Product> findByMaker(@Param("idMaker")Long idMaker);
    
}

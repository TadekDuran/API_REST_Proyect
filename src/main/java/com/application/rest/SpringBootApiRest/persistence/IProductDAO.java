package com.application.rest.SpringBootApiRest.persistence;

import com.application.rest.SpringBootApiRest.entities.Product;
import java.util.*;

public interface IProductDAO {
    
    List<Product> findAll();
    
    Optional<Product> findById(Long id);
    
    List<Product> findByPriceInRange(Double minPrice, Double maxPrice);
    
    List<Product> findByMaker(Long idMaker);
    
    void save(Product product);
    
    void deleteById(Long id);
    
}

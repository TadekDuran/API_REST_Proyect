package com.application.rest.SpringBootApiRest.persistence;

import com.application.rest.SpringBootApiRest.entities.Product;
import com.application.rest.SpringBootApiRest.repositories.ProductRepository;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
    
    @Autowired
    private ProductRepository productRepo;
            
    public List<Product> findAll() {
        return productRepo.findAll();
    };
    
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    };
    
    public List<Product> findByPriceInRange(Double minPrice, Double maxPrice)  {
        return productRepo.findProductsByPriceInRange(minPrice, maxPrice);
    };
    
    public List<Product> findByMaker(Long idMaker) {
        return productRepo.findByMaker(idMaker);
    };
    
    public void save(Product product)  {
        productRepo.save(product);
    };
    
    public void deleteById(Long id)    {
        productRepo.deleteById(id);
    };
    
}

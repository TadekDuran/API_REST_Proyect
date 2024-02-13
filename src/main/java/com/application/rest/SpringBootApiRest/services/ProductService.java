
package com.application.rest.SpringBootApiRest.services;

import com.application.rest.SpringBootApiRest.entities.Product;
import com.application.rest.SpringBootApiRest.persistence.ProductDAO;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    
    @Autowired
    private ProductDAO productDao;
    
    public List<Product> findAll() {
        return productDao.findAll();
    };
    
    public Optional<Product> findById(Long id) {
        return productDao.findById(id);
    };
    
    public List<Product> findByPriceInRange(Double minPrice, Double maxPrice)  {
        return productDao.findByPriceInRange(minPrice, maxPrice);
    };
    
    public List<Product> findByMaker(Long idMaker) {
        return productDao.findByMaker(idMaker);
    };
    
    public void save(Product product)  {
        productDao.save(product);
    };
    
    public void deleteById(Long id)    {
        productDao.deleteById(id);
    };
    
}

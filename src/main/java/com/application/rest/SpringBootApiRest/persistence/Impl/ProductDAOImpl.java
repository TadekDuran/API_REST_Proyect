package com.application.rest.SpringBootApiRest.persistence.Impl;

import com.application.rest.SpringBootApiRest.entities.Product;
import com.application.rest.SpringBootApiRest.persistence.IProductDAO;
import com.application.rest.SpringBootApiRest.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements IProductDAO {
    
    @Autowired
    private ProductRepository productRepo;
    
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public List<Product> findByPriceInRange(Double minPrice, Double maxPrice) {
        return productRepo.findProductsByPriceInRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByMaker(Long idMaker) {
        return productRepo.findByMaker(idMaker);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

}

package com.bree.com.service.impl;

import com.bree.com.models.Product;
import com.bree.com.repository.ProductRepository;
import com.bree.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(List<Product> product) {
        return productRepository.saveAll(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteAll() {
productRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product>findById = productRepository.findById(id);
        return findById.orElse(null);
    }

    @Override
    public Product findByProductId(String productId) {
        Optional<Product>findById = productRepository.findByProductId(productId);
        return findById.orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}

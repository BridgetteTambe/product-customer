package com.bree.com.service;


import com.bree.com.models.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> saveAll(List<Product>  product);


    Product update(Product product);

    void deleteAll();

    void deleteById(Long id);

    Product findById(Long id);

    List<Product> findAll();


}

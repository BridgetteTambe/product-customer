package com.bree.com.resources;

import com.bree.com.models.Order;

import com.bree.com.models.Product;
import com.bree.com.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:4200/" )
public class ProductResource {

    @Autowired
    ProductService productService;
    private Logger LOGGER = LoggerFactory.getLogger(ProductResource.class);

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id){
        LOGGER.info("Rest request to get product  by id:{}", id);
        return productService.findById(id);
    }

    @GetMapping("/products")
    List<Product> findAll() {
        LOGGER.info("Rest request to get all product:");
        return productService.findAll();
    }


}

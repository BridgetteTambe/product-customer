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

    @PostMapping("/product")
    public Product save(@RequestBody Product product)throws Exception{
        LOGGER.info("Rest request to save product data:{}",product);
        if(product.getId() != null){
            throw new Exception("Cant save product with id");
        }
        return productService.save(product);
    }
    @PutMapping("/product")
    public Product updateAddress(@RequestBody Product product)throws Exception{
        LOGGER.info("Rest request to update product with id:{}",product);
        if(product.getId() == null){
            throw new Exception("Cant update product with a null id:{}");
        }
        return productService.save(product);

    }
    @GetMapping("/Product/{id}")
    public Product getById(@PathVariable Long id){
        LOGGER.info("Rest request to get product  by id:{}", id);
        return productService.findById(id);
    }

    @GetMapping("/product")
    List<Product> findAll() {
        LOGGER.info("Rest request to get all product:");
        return productService.findAll();
    }

    @DeleteMapping("/product/{id}")
    public void deleteById(@PathVariable Long id){
        LOGGER.info("Rest request to delete product by id:{}",id);
        productService.deleteById(id);
    }

    @DeleteMapping("/product")
    public void deleteAll(){
        LOGGER.info("Rest request to delete product:");
        productService.deleteAll();
    }

}

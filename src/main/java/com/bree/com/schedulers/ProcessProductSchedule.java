package com.bree.com.schedulers;

import com.bree.com.models.Product;
import com.bree.com.schedulers.dtos.ProductDto;
import com.bree.com.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProcessProductSchedule {
    private static final Logger LOG = LoggerFactory.getLogger(ProcessProductSchedule.class);
    @Autowired
    private ProductService productService;
    @Value("${not-process-products-url}")
    private String notProcessProductsUrl;
//    private String notProcessProductsUrl ="http://localhost:8080/api/products/not-process";

    @Value("${update-processed-products-url}")
    private String updateProcessedProductsUrl;

    /**
     * THis will run every 2 minute
     */
   // @Scheduled(fixedDelay = 1000l * 100)
    public void processProducts() {
        LOG.info("processProducts ran at: {}", LocalDateTime.now());

        List<ProductDto> productsFromAdmin = getProductsFromAdmin();
//        List of products to be save in mysql
        List<Product> productList = new ArrayList<>();

        productsFromAdmin.forEach((adminProduct) -> {
            Product product = new Product();
            product.setName(adminProduct.getName());
            product.setCategory(adminProduct.getCategory());
            product.setPrice(adminProduct.getPrice());
            product.setDiscount(adminProduct.getDiscount());
            product.setWeight(adminProduct.getWeight());
            product.setQuantity(adminProduct.getQuantity());
            product.setProductId(adminProduct.getId());

            productList.add(product);
            // setting processed to true
            adminProduct.setProcessed(true);
        });

        this.productService.saveAll(productList);
        this.updateProductsInAdmin(productsFromAdmin);
    }


//    What is the main function of this???
    private List<ProductDto> getProductsFromAdmin() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("X-USERNAME", "Bridgette");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

//        ProductDto[] products = restTemplate.exchange("http://localhost:8080/api/products/not-process", HttpMethod.GET, entity, ProductDto[].class).getBody();
        ProductDto[] products = restTemplate.exchange(notProcessProductsUrl, HttpMethod.GET, entity, ProductDto[].class).getBody();
        List<ProductDto> productList = Arrays.asList(products);
        return productList;
    }

    private List<ProductDto> updateProductsInAdmin(List<ProductDto> productDtos) {

        HttpEntity<List<ProductDto>> entity = new HttpEntity<>(productDtos);

        RestTemplate restTemplate = new RestTemplate();

        ProductDto[] products = restTemplate.exchange(updateProcessedProductsUrl, HttpMethod.PUT, entity, ProductDto[].class).getBody();
        List<ProductDto> productList = Arrays.asList(products);
        return productList;
    }

}

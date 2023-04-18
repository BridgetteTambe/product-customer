package com.bree.com.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Data

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    //The product Id will be use to link us back to the products in admin
    @Column(name = "product_id", unique = true, updatable = false)
    private Long Id;

    @Column(name = "price", precision = 3)
    private BigDecimal price;

    @Column(name = "discount")
    private BigDecimal discount;

    private String category;

    private String weight;

    private Long quantity;


}

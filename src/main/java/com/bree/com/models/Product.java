package com.bree.com.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="products")
public class Product {
    public static final String SEQUENCE_NAME = "product";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    //The product Id will be use to link us back to the products in admin
    @Column(name = "product_id", unique = true, updatable = false)
    private String productId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discount")
    private BigDecimal discount;

    private String category;

    private String weight;

    private Long quantity;
    private Instant syncDate;


}

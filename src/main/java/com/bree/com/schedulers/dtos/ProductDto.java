package com.bree.com.schedulers.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDto {
    private String id;
    private String name;
    private BigDecimal price;
    private BigDecimal discount;
    private String category;
    private String weight;
    private Long quantity;
    private String adminId;
    private Boolean processed;
}

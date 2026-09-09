package com.warehouse.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ItemResponseDto {
    Long id;
    String productName;
    String sku;
    BigDecimal retailPrice;
    Integer stockQuantity;
    String description;
}

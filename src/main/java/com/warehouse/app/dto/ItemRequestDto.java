package com.warehouse.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter @AllArgsConstructor
public class ItemRequestDto {
    String productName;
    String description;
    String sku;  // stock Keeping Barcode
    BigDecimal retailPrice;
    BigDecimal wholesalePrice;
    Integer stockQuantity;
    String binLocation;
    String supplierContactEmail;
}

package com.warehouse.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity @Getter @Setter @NoArgsConstructor
public class WarehouseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String productName;
    @Lob
            @Column(name = "Product Description")
    String description;
    BigDecimal retailPrice;
    BigDecimal wholesalePrice;
    Integer stockQuantity;
    @Column(name = "Supplier Email")
    String supplierContactEmail;
    @Column(name = "Stock Keeping Barcode", unique = true)
    String sku;   // barcode for scanning the item(sku) stock Keeping Barcode
    String binLocation;

}


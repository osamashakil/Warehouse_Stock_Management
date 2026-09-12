package com.warehouse.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter @Setter @NoArgsConstructor
public class ItemRequestDto {
        @NotBlank(message = "Product name cannot be blank")
             @Size(max = 100, message = "Product name must not exceed 100 characters")
    String productName;
             @Size(max = 500, message = "Desciption must not exceed 500 characters")
    String description;
        @NotBlank(message = "SKU cannot be blank")
             @Pattern(regexp = "^[A-Z0-9-]+$", message = "SKU must contain only uppercase letter, numbers, and hyphens")
    String sku;  // stock Keeping Barcode
    @NotNull(message = "Retail Price Required")
            @Positive(message = "Retail price must be greater than zero")
    BigDecimal retailPrice;
    @NotNull(message = "Wholesale price required")
            @Positive(message = "Wholesale price must be greater than zero")
    BigDecimal wholesalePrice;
    @NotNull(message = "Stock quantity required")
            @PositiveOrZero(message = "Stock quantity must be greater than zero")
    Integer stockQuantity;
    @NotBlank(message = "Bin location is required")
            @Pattern(regexp = "^AISLE-[0-9]{2}-RACK-[A-Z]-BIN-[0-9]{2}$",
                    message = "Bin location must follow format: AISLE-01-RACK-A-BIN-01")
    String binLocation;
    @NotBlank(message = "Supplier contact email is required")
    @Email(message = "Invalid supplier email address format")
    String supplierContactEmail;
}

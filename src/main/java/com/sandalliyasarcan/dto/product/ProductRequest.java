package com.sandalliyasarcan.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "Product name cannot be null !!!")
    @NotEmpty(message = "Product name cannot be empty !!!")
    private String productName;


    @NotNull(message = "Product description cannot be null !!!")
    @NotEmpty(message = "Product description cannot be empty !!!")
    private String description;


    @Min(value = 0, message = "Unit price cannot be negative !!!")
    @NotNull(message = "Unit price cannot be null !!!")
    private BigDecimal unitPrice;


    @Min(value = 0, message = "Units in stock cannot be negative !!!")
    @NotNull(message = "Units in stock cannot be null !!!")
    private Integer unitsInStock;

    @NotNull(message = "Category id cannot be null !!!")
    private Integer categoryId;

    @NotNull(message = "Brand cannot be null !!!")
    @NotEmpty(message = "Brand cannot be empty !!!")
    @Size(min = 3, max = 30, message = "Brand name must be between 3 and 30 characters !!!")
    private String brand;

    @NotNull(message = "SKU cannot be null !!!")
    @NotEmpty(message = "SKU cannot be empty !!!")
    @Size(min = 1, max = 20, message = "SKU must be between 1 and 20 characters !!!")
    private String sku;

    @NotNull(message = "Product image cannot be null !!!")
    private LocalDateTime createdAt;

    @NotNull(message = "Product image cannot be null !!!")
    private LocalDateTime updatedAt;

}
package com.sandalliyasarcan.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String productName;
    private String description;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private String categoryName; // bu kismi Sevda Hanima sorucam , categoryName field i Product class inda yok ama iliskli oldugu Category class inda var baska bir classin fiealdini cekmek ne kadar dogru bir teknik
    private String brand;
}

package com.sandalliyasarcan.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private String orderStatus;
    private LocalDateTime orderDate;
    private Long customerId;
}

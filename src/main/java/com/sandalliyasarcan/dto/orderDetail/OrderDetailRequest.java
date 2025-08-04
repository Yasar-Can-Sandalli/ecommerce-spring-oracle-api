package com.sandalliyasarcan.dto.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequest {
    private Integer quantity;
    private Long productId;
    private Double unitPrice;
    private Long orderId;
}

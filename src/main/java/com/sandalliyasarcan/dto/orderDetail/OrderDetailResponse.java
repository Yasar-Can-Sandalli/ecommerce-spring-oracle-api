package com.sandalliyasarcan.dto.orderDetail;

import com.sandalliyasarcan.dto.order.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private Long orderDetailId;
    private Integer quantity;
    private Double unitPrice;
    private Double totalPrice ;
    private OrderResponse order;
    private Long productId;
}

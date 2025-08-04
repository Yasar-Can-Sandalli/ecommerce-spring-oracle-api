package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.dto.order.OrderRequest;
import com.sandalliyasarcan.dto.order.OrderResponse;

import java.util.List;

public interface IOrderController {
    OrderResponse saveOrder(OrderRequest orderDTO);
    OrderResponse getOrderById(Long orderId);
    OrderResponse deleteOrderById(Long orderId);
    OrderResponse updateOrderById(Long orderId, OrderRequest orderRequest);
    List<OrderResponse> getAllOrders();
    List<OrderResponse> getAllOrdersByCustomerId(Long customerId);


}

package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.dto.orderDetail.OrderDetailRequest;
import com.sandalliyasarcan.dto.orderDetail.OrderDetailResponse;

import java.util.List;

public interface IOrderDetailController {
    OrderDetailResponse saveOrderDetail(OrderDetailRequest orderDetailRequest);
    OrderDetailResponse getOrderDetailById(Long orderDetailId);
    List<OrderDetailResponse> getAllOrderDetailsByOrderId(Long orderId);
    OrderDetailResponse updateOrderDetailById(Long orderDetailId, OrderDetailRequest orderDetailRequest);
    OrderDetailResponse deleteOrderDetailById(Long orderDetailId);
    List<OrderDetailResponse> getAllOrderDetails();


}

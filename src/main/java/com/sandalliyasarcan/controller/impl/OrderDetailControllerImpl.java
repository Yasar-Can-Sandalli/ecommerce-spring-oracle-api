package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.IOrderDetailController;
import com.sandalliyasarcan.dto.orderDetail.OrderDetailRequest;
import com.sandalliyasarcan.dto.orderDetail.OrderDetailResponse;
import com.sandalliyasarcan.services.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/orderDetail/")
public class OrderDetailControllerImpl implements IOrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @Override
    @PostMapping(path = "/save")
    public OrderDetailResponse saveOrderDetail(@RequestBody OrderDetailRequest orderDetailRequest) {
        return orderDetailService.saveOrderDetail(orderDetailRequest);
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public OrderDetailResponse getOrderDetailById(@PathVariable(name = "id" , required = true) Long orderDetailId) {
        return orderDetailService.getOrderDetailById(orderDetailId);
    }

    @Override
    @GetMapping(path = "/allOrderDetail/{id}")
    public List<OrderDetailResponse> getAllOrderDetailsByOrderId(@PathVariable(name = "id" ,required = true) Long orderId) {
        return orderDetailService.getAllOrderDetailsByOrderId(orderId);
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public OrderDetailResponse updateOrderDetailById(@PathVariable(name = "id" , required = true) Long orderDetailId, @RequestBody OrderDetailRequest orderDetailRequest) {
        return orderDetailService.updateOrderDetailById(orderDetailId,orderDetailRequest);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public OrderDetailResponse deleteOrderDetailById(@PathVariable(name = "id" ,required = true) Long orderDetailId) {
        return orderDetailService.deleteOrderDetailById(orderDetailId);
    }

    @Override
    @GetMapping(path = "/list")
    public List<OrderDetailResponse> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

}

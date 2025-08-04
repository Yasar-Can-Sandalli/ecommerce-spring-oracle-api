package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.IOrderController;
import com.sandalliyasarcan.dto.order.OrderRequest;
import com.sandalliyasarcan.dto.order.OrderResponse;
import com.sandalliyasarcan.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/order/")
public class OrderControllerImpl implements IOrderController {

    @Autowired
    private IOrderService orderService;


    @Override
    @PostMapping(path = "/save")
    public OrderResponse saveOrder(@RequestBody OrderRequest orderDTO) {
        return orderService.saveOrder(orderDTO);
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public OrderResponse getOrderById(@PathVariable(name = "id",required = true) Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public OrderResponse deleteOrderById(@PathVariable(name = "id" ,required = true) Long orderId) {
        return orderService.deleteOrderById(orderId);
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public OrderResponse updateOrderById(@PathVariable(name = "id" ,required = true) Long orderId, @RequestBody OrderRequest orderRequest) {
        return orderService.updateOrderById(orderId,orderRequest);
    }

    @Override
    @GetMapping(path = "/list")
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    @GetMapping(path = "/getOrderWithCustomerId/{id}")
    public List<OrderResponse> getAllOrdersByCustomerId(@PathVariable(name = "id" , required = true) Long customerId) {
        return orderService.getAllOrdersByCustomerId(customerId);
    }

}

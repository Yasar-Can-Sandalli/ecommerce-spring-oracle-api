package com.sandalliyasarcan.services.impl;

import com.sandalliyasarcan.dto.order.OrderConverter;
import com.sandalliyasarcan.dto.order.OrderRequest;
import com.sandalliyasarcan.dto.order.OrderResponse;
import com.sandalliyasarcan.entities.Order;
import com.sandalliyasarcan.repository.CustomerRepository;
import com.sandalliyasarcan.repository.OrderRepository;
import com.sandalliyasarcan.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderResponse saveOrder(OrderRequest orderDTO) {
        Order order = orderConverter.toOrderEntity(orderDTO);
        orderRepository.save(order);
        return orderConverter.convertOrderToOrderResponse(order);
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()){
            return orderConverter.convertOrderToOrderResponse(optionalOrder.get());
        }else{
            throw new RuntimeException("Order not found with id: " + orderId);//OrderNotFoundException
        }
    }

    @Override
    public OrderResponse deleteOrderById(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()){
            orderRepository.delete(order.get());
            return orderConverter.convertOrderToOrderResponse(order.get());
        }else {
            throw new RuntimeException("Order not found with id: " + orderId);//OrderNotFoundException
        }



    }

    @Override
    public OrderResponse updateOrderById(Long orderId, OrderRequest orderRequest) {

        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()){
            Order dBorder = order.get();
            dBorder.setOrderDate(orderRequest.getOrderDate());
            dBorder.setOrderStatus(orderRequest.getOrderStatus());
            dBorder.setCustomer(customerRepository.findById(orderRequest.getCustomerId()).get());
            orderRepository.save(dBorder);
            return orderConverter.convertOrderToOrderResponse(dBorder);
        }else {
            throw new RuntimeException("Order not found with id: " + orderId);//OrderNotFoundException
        }
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<OrderResponse>  orderResponseList = new ArrayList<>();

        for (Order order : orderRepository.findAll()) {
            orderResponseList.add(orderConverter.convertOrderToOrderResponse(order));
        }

        return orderResponseList;

    }

    @Override
    public List<OrderResponse> getAllOrdersByCustomerId(Long customerId) {
        List<OrderResponse>  orderResponseList = new ArrayList<>();

        for (Order order : orderRepository.findAll()){
            if (order.getCustomer().getCustomerId().equals(customerId)){
                orderResponseList.add(orderConverter.convertOrderToOrderResponse(order));
            }
        }

        return orderResponseList;
    }

}

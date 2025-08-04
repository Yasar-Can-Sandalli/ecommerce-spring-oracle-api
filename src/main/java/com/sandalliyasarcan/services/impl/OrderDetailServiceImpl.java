package com.sandalliyasarcan.services.impl;

import com.sandalliyasarcan.dto.orderDetail.OrderDetailConverter;
import com.sandalliyasarcan.dto.orderDetail.OrderDetailRequest;
import com.sandalliyasarcan.dto.orderDetail.OrderDetailResponse;
import com.sandalliyasarcan.entities.OrderDetail;
import com.sandalliyasarcan.repository.OrderDetailRepository;
import com.sandalliyasarcan.repository.OrderRepository;
import com.sandalliyasarcan.repository.ProductRepository;
import com.sandalliyasarcan.services.IOrderDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailConverter orderDetailConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDetailResponse saveOrderDetail(OrderDetailRequest orderDetailRequest) {
        OrderDetailResponse orderDetailResponse;
        OrderDetail orderDetail = orderDetailConverter.toOrderDetailEntity(orderDetailRequest);
        orderDetailRepository.save(orderDetail);
        orderDetailResponse = orderDetailConverter.toOrderDetailResponse(orderDetail);
        return orderDetailResponse;
    }

    @Override
    public OrderDetailResponse getOrderDetailById(Long orderDetailId) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(orderDetailId);
        if (optionalOrderDetail.isPresent()){
            return orderDetailConverter.toOrderDetailResponse(optionalOrderDetail.get());
        }else {
            throw new RuntimeException("OrderDetail not found with id: " + orderDetailId);//OrderDetailNotFoundException
        }
    }

    @Override
    public List<OrderDetailResponse> getAllOrderDetailsByOrderId(Long orderId) {
        List<OrderDetail> allOrderDetail = new ArrayList<>();

        for (OrderDetail orderDetail : orderDetailRepository.findAll() ){
            if (orderDetail.getOrder().getOrderId().equals(orderId)){
                allOrderDetail.add(orderDetail);
            }
        }

        List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();

        for (OrderDetail orderDetail : allOrderDetail){
            orderDetailResponses.add(orderDetailConverter.toOrderDetailResponse(orderDetail));
        }

        return orderDetailResponses;

    }

    @Override
    public OrderDetailResponse updateOrderDetailById(Long orderDetailId, OrderDetailRequest orderDetailRequest) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(orderDetailId);

        if (orderDetail.isPresent()){
            orderDetail.get().setQuantity(orderDetailRequest.getQuantity());
            orderDetail.get().setProduct(productRepository.findById(orderDetailRequest.getProductId()).get());
            orderDetail.get().setOrder(orderRepository.findById(orderDetailRequest.getOrderId()).get());
            orderDetailRepository.save(orderDetail.get());
            return orderDetailConverter.toOrderDetailResponse(orderDetail.get());
        }else{
            throw new RuntimeException("OrderDetail not found with id: " + orderDetailId);//OrderDetailNotFoundException
        }

    }

    @Override
    public OrderDetailResponse deleteOrderDetailById(Long orderDetailId) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(orderDetailId);
        if (orderDetail.isPresent()){
            orderDetailRepository.delete(orderDetail.get());
            return orderDetailConverter.toOrderDetailResponse(orderDetail.get());
        }else{
            throw new RuntimeException("OrderDetail not found with id: " + orderDetailId);//OrderDetailNotFoundException
        }
    }

    @Override
    public List<OrderDetailResponse> getAllOrderDetails() {
        List<OrderDetailResponse> allOrderDetail = new ArrayList<>();

        for (OrderDetail orderDetail : orderDetailRepository.findAll()){
            allOrderDetail.add(orderDetailConverter.toOrderDetailResponse(orderDetail));
        }

        return allOrderDetail;

    }


}

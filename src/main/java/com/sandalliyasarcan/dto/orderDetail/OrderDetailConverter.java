package com.sandalliyasarcan.dto.orderDetail;


import com.sandalliyasarcan.dto.order.OrderConverter;
import com.sandalliyasarcan.entities.OrderDetail;
import com.sandalliyasarcan.entities.Product;
import com.sandalliyasarcan.repository.OrderRepository;
import com.sandalliyasarcan.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderDetailConverter {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private ProductRepository productRepository;


    public OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail){
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        BeanUtils.copyProperties(orderDetail, orderDetailResponse);
        orderDetailResponse.setOrder(orderConverter.convertOrderToOrderResponse(orderDetail.getOrder()));
        orderDetailResponse.setProductId(orderDetail.getProduct().getProductId());
        return orderDetailResponse;
    }

    public OrderDetail toOrderDetailEntity(OrderDetailRequest orderDetailRequest){
        OrderDetail orderDetail = new OrderDetail();
        BeanUtils.copyProperties(orderDetailRequest, orderDetail);

        Optional<Product> product = productRepository.findById(orderDetailRequest.getProductId());


        if (product.isPresent()){
            orderDetail.setOrder(orderRepository.findById(orderDetailRequest.getOrderId()).orElse(null));
            orderDetail.setProduct(productRepository.findById(orderDetailRequest.getProductId()).orElse(null) );//OrderNotFoundEx
            orderDetail.setTotalPrice(orderDetail.getUnitPrice() * orderDetail.getQuantity());
            return orderDetail;
        }else{
            throw new RuntimeException("Product not found"); //ProductNotFound
        }



    }

}

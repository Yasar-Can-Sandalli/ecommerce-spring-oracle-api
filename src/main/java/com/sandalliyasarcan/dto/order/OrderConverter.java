package com.sandalliyasarcan.dto.order;

import com.sandalliyasarcan.dto.customer.CustomerConverter;
import com.sandalliyasarcan.entities.Order;
import com.sandalliyasarcan.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerRepository customerRepository;

    public OrderResponse convertOrderToOrderResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(order, orderResponse);
        orderResponse.setCustomerResponse(customerConverter.toDtoResponse(order.getCustomer()));
        return orderResponse;

    }

    public Order toOrderEntity(OrderRequest orderRequest){
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        order.setCustomer(customerRepository.findById(orderRequest.getCustomerId()).get());
        return order;
    }


}

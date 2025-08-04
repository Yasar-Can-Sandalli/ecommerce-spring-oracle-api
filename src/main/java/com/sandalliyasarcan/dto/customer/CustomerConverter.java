package com.sandalliyasarcan.dto.customer;

import com.sandalliyasarcan.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    public Customer toEntity(CustomerRequest customerRequest){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        return customer;
    }


    public CustomerResponse toDtoResponse(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        BeanUtils.copyProperties(customer, customerResponse);

        return customerResponse;
    }


}

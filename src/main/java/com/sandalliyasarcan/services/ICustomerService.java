package com.sandalliyasarcan.services;

import com.sandalliyasarcan.dto.customer.CustomerRequest;
import com.sandalliyasarcan.dto.customer.CustomerResponse;

import java.util.List;

public interface ICustomerService {
    List<CustomerResponse> getAllCustomers();
    CustomerResponse saveCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(Long customerId);
    CustomerResponse deleteByCustomerId(Long customerId);
    CustomerResponse updateCustomerById(Long customerId, CustomerRequest customerRequest);
    List<CustomerResponse> getCustomerWithParams(String firstName, String lastName);
}

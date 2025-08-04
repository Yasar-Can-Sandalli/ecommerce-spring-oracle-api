package com.sandalliyasarcan.controller;

import com.sandalliyasarcan.dto.customer.CustomerRequest;
import com.sandalliyasarcan.dto.customer.CustomerResponse;

import java.util.List;

public interface ICustomerController {
    CustomerResponse saveCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(Long customerId);
    CustomerResponse deleteByCustomerId(Long customerId);
    List<CustomerResponse> getAllCustomers();
    CustomerResponse updateCustomerById(Long customerId, CustomerRequest customerRequest);
    List<CustomerResponse> getCustomerWithParamsFirstNameOrLastName(String firstName, String lastName);
}

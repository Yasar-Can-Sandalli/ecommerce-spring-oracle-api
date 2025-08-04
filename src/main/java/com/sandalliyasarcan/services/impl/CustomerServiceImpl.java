package com.sandalliyasarcan.services.impl;


import com.sandalliyasarcan.dto.customer.CustomerConverter;
import com.sandalliyasarcan.dto.customer.CustomerRequest;
import com.sandalliyasarcan.dto.customer.CustomerResponse;
import com.sandalliyasarcan.entities.Customer;
import com.sandalliyasarcan.repository.CustomerRepository;
import com.sandalliyasarcan.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        List<Customer> dbCustomers = new ArrayList<>(customerRepository.findAll());


        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : dbCustomers){
            customerResponses.add(this.customerConverter.toDtoResponse(customer));
        }
        return customerResponses;


    }

    @Override
    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        Customer customer = this.customerConverter.toEntity(customerRequest);
        customerRepository.save(customer);
        return this.customerConverter.toDtoResponse(customer);
    }

    @Override
    public CustomerResponse getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer  =  customerRepository.findById(customerId);
        CustomerResponse customerResponse = new CustomerResponse();
        if (optionalCustomer.isPresent()){
            customerResponse = this.customerConverter.toDtoResponse(optionalCustomer.get());
        }else {
            throw new RuntimeException("Customer not found with id: " + customerId);//CustomerNotFoundException
        }
        return customerResponse;


    }

    @Override
    public CustomerResponse deleteByCustomerId(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()){
            customerRepository.delete(customer.get());
            return this.customerConverter.toDtoResponse(customer.get());
        }else{
            throw new RuntimeException("Customer not found with id: " + customerId);//CustomerNotFoudException
        }
    }

    @Override
    public CustomerResponse updateCustomerById(Long customerId, CustomerRequest customerRequest) {
        Optional<Customer> optionalDbCustomer = customerRepository.findById(customerId);

        if (optionalDbCustomer.isPresent()){
            Customer customer = optionalDbCustomer.get();
            BeanUtils.copyProperties(customerRequest, customer);
            customerRepository.save(customer);
            return this.customerConverter.toDtoResponse(customer);


        }else{
            throw new RuntimeException("Customer not found with id: " + customerId);
        }

    }

    @Override
    public List<CustomerResponse> getCustomerWithParams(String firstName, String lastName) {
        List<CustomerResponse> customers = new ArrayList<>();

        for (Customer customer : customerRepository.getCustomersWithParams(firstName, lastName)){
            CustomerResponse customerResponse = this.customerConverter.toDtoResponse(customer);
            customers.add(customerResponse);
        }
        return customers;

    }


}

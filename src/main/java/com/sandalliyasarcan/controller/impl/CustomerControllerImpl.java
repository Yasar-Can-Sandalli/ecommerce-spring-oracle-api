package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.ICustomerController;
import com.sandalliyasarcan.dto.customer.CustomerRequest;
import com.sandalliyasarcan.dto.customer.CustomerResponse;
import com.sandalliyasarcan.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/customer/")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @Override
    @PostMapping(path = "/save")
    public CustomerResponse saveCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.saveCustomer(customerRequest);
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public CustomerResponse getCustomerById(@PathVariable(name = "id" , required = true) Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public CustomerResponse deleteByCustomerId(@PathVariable(name = "id") Long customerId) {
        return customerService.deleteByCustomerId(customerId);
    }

    @Override
    @GetMapping(path = "/list")
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public CustomerResponse updateCustomerById(@PathVariable(name = "id" ,required = true) Long customerId,@RequestBody CustomerRequest customerRequest) {
        return customerService.updateCustomerById(customerId,customerRequest);
    }

    @Override
    @GetMapping(path = "/params")
    public List<CustomerResponse> getCustomerWithParamsFirstNameOrLastName(@RequestParam(name = "firstName" , required = false) String firstName, @RequestParam(name = "lastName" , required = false) String lastName) {
        return customerService.getCustomerWithParams(firstName,lastName);
    }
}

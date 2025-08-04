package com.sandalliyasarcan.dto.phoneNumber;

import com.sandalliyasarcan.dto.customer.CustomerConverter;
import com.sandalliyasarcan.entities.PhoneNumber;
import com.sandalliyasarcan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class PhoneNumberConverter {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    public CustomerPhoneNumberResponse convertToResponseWithCustomer(PhoneNumber phoneNumber) {//AI dan aldigim tek yer ve AI dan bu kisim icin aciklama istenecek 23. ve 31. satir icin
        CustomerPhoneNumberResponse response = new CustomerPhoneNumberResponse();
        var customer = phoneNumber.getCustomer(); //Burayi neden var olarak sakladik

        response.setCustomerId(customer.getCustomerId());
        response.setFullName(customer.getFirstName() + " " + customer.getLastName());
        response.setEmail(customer.getEmail());

        HashMap<String, List<String>> phoneMap = new HashMap<>();
        for (PhoneNumber p : customer.getPhoneNumbers()) {
            phoneMap.computeIfAbsent(p.getPhoneType(), k -> new java.util.ArrayList<>()).add(p.getPhoneNumber());//Bu kisim tam olarak ne yapiyor ?
        }

        response.setNumbers(phoneMap);
        return response;
    }


    public PhoneNumberResponse convertToResponseBasic(PhoneNumber phoneNumber) {
        PhoneNumberResponse response = new PhoneNumberResponse();
        response.setPhoneId(phoneNumber.getPhone_Id());
        response.setPhoneType(phoneNumber.getPhoneType());
        response.setPhoneNumber(phoneNumber.getPhoneNumber());
        response.setCustomerFullName(phoneNumber.getCustomer().getFirstName() + " " + phoneNumber.getCustomer().getLastName());
        return response;
    }


    public PhoneNumber convertToEntity(PhoneNumberRequest request) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneType(request.getPhoneType());
        phoneNumber.setPhoneNumber(request.getPhoneNumber());
        phoneNumber.setCustomer(customerRepository.findById(request.getCustomerId()).orElse(null)); // CustomerNotFoundException
        return phoneNumber;
    }

}

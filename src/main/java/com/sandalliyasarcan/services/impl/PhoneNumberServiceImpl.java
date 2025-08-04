package com.sandalliyasarcan.services.impl;

import com.sandalliyasarcan.dto.phoneNumber.CustomerPhoneNumberResponse;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberConverter;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberRequest;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberResponse;
import com.sandalliyasarcan.entities.PhoneNumber;
import com.sandalliyasarcan.repository.CustomerRepository;
import com.sandalliyasarcan.repository.PhoneNumberRepository;
import com.sandalliyasarcan.services.IPhoneNumberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImpl implements IPhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhoneNumberConverter phoneNumberConverter;


    @Override
    public List<PhoneNumberResponse> getAllPhoneNumbers() {
        List<PhoneNumberResponse> phoneNumberResponses = new ArrayList<>();
        for (PhoneNumber phoneNumber : phoneNumberRepository.findAll()) {
            PhoneNumberResponse phoneNumberResponse = phoneNumberConverter.convertToResponseBasic(phoneNumber);
            phoneNumberResponses.add(phoneNumberResponse);
        }
        return phoneNumberResponses;
    }

    @Override
    public CustomerPhoneNumberResponse getCustomerPhoneNumberByCustomerId(Long customerId) {
        List<CustomerPhoneNumberResponse> customerPhoneNumberResponses = new ArrayList<>();

        for (PhoneNumber phoneNumber : phoneNumberRepository.findAll()){
            if (phoneNumber.getCustomer().getCustomerId() == customerId){
                customerPhoneNumberResponses.add(phoneNumberConverter.convertToResponseWithCustomer(phoneNumber));
            }
        }
        return customerPhoneNumberResponses.get(0);
    }

    @Override
    public boolean deletePhoneNumberById(Long phoneNumberId) {
        Optional<PhoneNumber> phoneNumber  = phoneNumberRepository.findById(phoneNumberId);

        if (phoneNumber.isPresent()){
            phoneNumberRepository.deleteById(phoneNumberId);
            return true;
        }else {
            throw new RuntimeException("PhoneNumber not found with id: " + phoneNumberId);//PhoneNumberNotFoundException
        }
    }

    @Override
    public PhoneNumberResponse savePhoneNumber(PhoneNumberRequest phoneNumberRequest) {
        PhoneNumber phoneNumber = phoneNumberConverter.convertToEntity(phoneNumberRequest);
        phoneNumberRepository.save(phoneNumber);
        return phoneNumberConverter.convertToResponseBasic(phoneNumber);

    }

    @Override
    public PhoneNumberResponse getPhoneNumberById(Long phoneNumberId) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneNumberId);

        if (phoneNumber.isPresent()){
            return phoneNumberConverter.convertToResponseBasic(phoneNumber.get());
        }else{
            throw new RuntimeException("PhoneNumber not found with id: " + phoneNumberId);//PhoneNumberNotFoundException
        }

    }

    @Override
    public PhoneNumberResponse updatePhoneNumberById(Long phoneNumberId, PhoneNumberRequest phoneNumberRequest) {
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneNumberId);
        if (phoneNumber.isPresent()){
            PhoneNumber dbPhoneNumber = phoneNumber.get();
            BeanUtils.copyProperties(phoneNumberRequest, dbPhoneNumber);
            dbPhoneNumber.setCustomer(customerRepository.findById(phoneNumberRequest.getCustomerId()).get());
            phoneNumberRepository.save(dbPhoneNumber);
            return phoneNumberConverter.convertToResponseBasic(dbPhoneNumber);
        }else {
            throw new RuntimeException("PhoneNumber not found with id: " + phoneNumberId);//PhoneNumberNotFoundException
        }
    }

    @Override
    public PhoneNumberResponse getPhoneNumberByPhoneNumber(String phoneNumber) {
        PhoneNumber dbPhonNumber = phoneNumberRepository.getPhoneNumberByPhoneNumber(phoneNumber);

        if (dbPhonNumber != null){
            return phoneNumberConverter.convertToResponseBasic(dbPhonNumber);
        }else{
            throw new RuntimeException("PhoneNumber not found with id: " + phoneNumber);//PhoneNumberNotFound
        }




    }
}

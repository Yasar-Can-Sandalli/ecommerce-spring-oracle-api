package com.sandalliyasarcan.services;

import com.sandalliyasarcan.dto.phoneNumber.CustomerPhoneNumberResponse;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberRequest;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberResponse;

import java.util.List;

public interface IPhoneNumberService {
    List<PhoneNumberResponse> getAllPhoneNumbers();
    CustomerPhoneNumberResponse getCustomerPhoneNumberByCustomerId(Long customerId);
    boolean deletePhoneNumberById(Long phoneNumberId);
    PhoneNumberResponse savePhoneNumber(PhoneNumberRequest phoneNumberRequest);
    PhoneNumberResponse getPhoneNumberById(Long phoneNumberId);
    PhoneNumberResponse updatePhoneNumberById(Long phoneNumberId, PhoneNumberRequest phoneNumberRequest);
    PhoneNumberResponse getPhoneNumberByPhoneNumber(String phoneNumber);

}

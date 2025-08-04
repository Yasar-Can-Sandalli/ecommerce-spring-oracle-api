package com.sandalliyasarcan.controller.impl;

import com.sandalliyasarcan.controller.IPhoneNumberController;
import com.sandalliyasarcan.dto.phoneNumber.CustomerPhoneNumberResponse;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberRequest;
import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberResponse;
import com.sandalliyasarcan.services.IPhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/phoneNumber/")
public class PhonerNumberControllerImpl implements IPhoneNumberController {


    @Autowired
    private IPhoneNumberService phoneNumberService;


    @Override
    @GetMapping(path = "/list")
    public List<PhoneNumberResponse> getAllPhoneNumbers() {
        return phoneNumberService.getAllPhoneNumbers();
    }

    @Override
    @GetMapping(path = "/customer/{id}")
    public CustomerPhoneNumberResponse getCustomerPhoneNumberByCustomerId(@PathVariable(name = "id" ,required = true) Long customerId) {//23.numarali customerin tum numaralarini getir gibi
        return phoneNumberService.getCustomerPhoneNumberByCustomerId(customerId);
    }

    @Override
    @DeleteMapping(path = "/delete/{id}")
    public boolean deletePhoneNumberById(@PathVariable(name = "id" , required = true) Long phoneNumberId) {
        return phoneNumberService.deletePhoneNumberById(phoneNumberId);
    }

    @Override
    @PostMapping(path = "/save")
    public PhoneNumberResponse savePhoneNumber(@RequestBody PhoneNumberRequest phoneNumberRequest) {
        return phoneNumberService.savePhoneNumber(phoneNumberRequest);
    }

    @Override
    @GetMapping(path = "/find/{id}")
    public PhoneNumberResponse getPhoneNumberById(@PathVariable(name = "id" ,required = true) Long phoneNumberId) {
        return phoneNumberService.getPhoneNumberById(phoneNumberId);
    }

    @Override
    @PutMapping(path = "/update/{id}")
    public PhoneNumberResponse updatePhoneNumberById(@PathVariable(name = "id" ,required = true) Long phoneNumberId, @RequestBody PhoneNumberRequest phoneNumberRequest) {
        return phoneNumberService.updatePhoneNumberById(phoneNumberId,phoneNumberRequest);
    }

    @Override
    @GetMapping(path = "/phone/{number}")
    public PhoneNumberResponse getPhoneNumberByPhoneNumber(@PathVariable(name = "number" ,required = true) String phoneNumber) {
        return phoneNumberService.getPhoneNumberByPhoneNumber(phoneNumber);
    }
}
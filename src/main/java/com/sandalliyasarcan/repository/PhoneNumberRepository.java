package com.sandalliyasarcan.repository;

import com.sandalliyasarcan.dto.phoneNumber.PhoneNumberResponse;
import com.sandalliyasarcan.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {

    @Query(value = "SELECT * FROM PHONE_NUMBERS WHERE PHONE_NUMBER = :number", nativeQuery = true)
    PhoneNumber getPhoneNumberByPhoneNumber(String number);

}

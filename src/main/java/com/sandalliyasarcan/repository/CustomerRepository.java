package com.sandalliyasarcan.repository;

import com.sandalliyasarcan.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{


    @Query(value = "SELECT * FROM CUSTOMERS WHERE LOWER(FIRST_NAME) = LOWER(:firstName) OR LOWER(LAST_NAME) = LOWER(:lastName)", nativeQuery = true)
    List<Customer> getCustomersWithParams(String firstName, String lastName);

}

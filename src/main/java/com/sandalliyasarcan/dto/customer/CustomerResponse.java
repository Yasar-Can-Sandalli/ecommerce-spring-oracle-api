package com.sandalliyasarcan.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String country;
}

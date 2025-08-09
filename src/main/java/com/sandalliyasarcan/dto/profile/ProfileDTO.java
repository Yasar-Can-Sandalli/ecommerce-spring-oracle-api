package com.sandalliyasarcan.dto.profile;

import com.sandalliyasarcan.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {

    private String imageUrl;
    private String username;
    private String password;
    private Customer customer;
}

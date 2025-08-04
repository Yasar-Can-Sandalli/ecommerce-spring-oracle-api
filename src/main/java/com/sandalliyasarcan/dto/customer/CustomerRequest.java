package com.sandalliyasarcan.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequest {

    @NotNull(message = "First name cannot be null")
    @NotBlank(message = "First name cannot be empty")
    @Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters")
    private String firstName;


    @NotNull(message = "Last name cannot be null")
    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters")
    private String lastName;

    @Email(message = "Email is not valid")
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be empty")
    private String email;


    @NotNull(message = "Address cannot be null")
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @NotNull(message = "Postal code cannot be null")
    @NotBlank(message = "Postal code cannot be empty")
    @Size(min = 6, max = 6, message = "Postal Code must 6 character")
    private String postalCode;


    @NotNull(message = "City cannot be null")
    @NotBlank(message = "City cannot be empty")
    @Size(min = 3, max = 20, message = "City name must be between 3 and 20 characters")
    private String city;

    @NotNull(message = "Country cannot be null")
    @NotBlank(message = "Country cannot be empty")
    @Size(min = 3, max = 20, message = "Country name must be between 3 and 20 characters")
    private String country;
}

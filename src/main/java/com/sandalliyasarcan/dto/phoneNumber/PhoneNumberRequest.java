package com.sandalliyasarcan.dto.phoneNumber;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberRequest {

    @NotEmpty(message = "Phone type cannot be empty !!!")
    @NotNull(message = "Phone type cannot be null !!!")
    private String phoneType;

    @NotEmpty(message = "Phone type cannot be empty !!!")
    @NotNull(message = "Phone type cannot be null !!!")
    @Size(min = 13, max = 13 , message = "PhoneNumber must 13 character")
    private String phoneNumber;

    @NotEmpty(message = "customer id cannot be empty !!!")
    @NotNull(message = "customer id cannot be null !!!")
    private Long customerId;
}

package com.sandalliyasarcan.dto.phoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPhoneNumberResponse { //Customer ile beraber donucek response classi
    private Long customerId;
    private String fullName;
    private String email;
    private HashMap<String, List<String>> numbers = new HashMap<>();
}


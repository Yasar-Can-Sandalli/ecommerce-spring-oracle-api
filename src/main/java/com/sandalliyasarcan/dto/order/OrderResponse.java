package com.sandalliyasarcan.dto.order;

import com.sandalliyasarcan.dto.customer.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private String orderStatus;
    private Double totalPrice;
    private LocalDateTime orderDate;
    private CustomerResponse customerResponse;

    //OrderDetails de olmali mi bence olmaz sa daha iyi olur , ben ikisinin de birlekte geldigi baska sinif hazirlayacagim
    //Boyle bir sey yapabilirz dimi CHAT GPT ??
}

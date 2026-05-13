package com.academy.subscription.dto;

import com.academy.subscription.entity.PaymentMethod;
import com.academy.subscription.entity.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreatePaymentRequest {
    private Long subscriptionId;
    private PaymentMethod paymentMethod;
    private PaymentStatus status;
    private String couponCode;
}

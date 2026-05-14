package com.academy.subscription.dto;

import lombok.Data;

@Data
public class CreateSubscriptionRequest {

    private Long membershipId;
    private Long planId;
    private Double customPrice;
    private Double discountPercentage;
}

package com.academy.subscription.dto;

import java.time.LocalDate;

import com.academy.subscription.entity.DiscountType;

import lombok.Data;

@Data
public class CreateCouponRequest {
    private DiscountType discountType;
    private Long organizationId;
    private String code;
    private Double discountValue;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private Integer maxUsage;
}

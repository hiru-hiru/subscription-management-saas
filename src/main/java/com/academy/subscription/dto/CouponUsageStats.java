package com.academy.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CouponUsageStats {
    private String code;
    private Integer usageCount;
}

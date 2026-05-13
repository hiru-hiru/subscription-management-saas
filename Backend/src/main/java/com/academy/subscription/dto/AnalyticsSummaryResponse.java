package com.academy.subscription.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AnalyticsSummaryResponse {
    private long totalMembers;
    private long activeMembers;
    private long activeSubscriptions;
    private double totalRevenue;
    private long expiringIn7Days;
    private long couponUsageCount;
    private List<CouponUsageStats> couponUsageStats;
}

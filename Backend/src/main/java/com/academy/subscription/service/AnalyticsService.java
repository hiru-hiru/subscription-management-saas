package com.academy.subscription.service;

import com.academy.subscription.dto.AnalyticsSummaryResponse;
import com.academy.subscription.dto.CouponUsageStats;
import com.academy.subscription.entity.MembershipStatus;
import com.academy.subscription.entity.SubscriptionStatus;
import com.academy.subscription.repository.CouponRepository;
import com.academy.subscription.repository.MembershipRepository;
import com.academy.subscription.repository.PaymentRepository;
import com.academy.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsService {
    private final SubscriptionRepository subscriptionRepository;
    private final MembershipRepository membershipRepository;
    private final CouponRepository couponRepository;
    private final PaymentRepository paymentRepository;

    public AnalyticsSummaryResponse getSummary(Long organizationId) {
        long totalMembers = membershipRepository.countByOrganizationId(organizationId);

        long activeMembers = membershipRepository.countByOrganizationIdAndStatus(
                organizationId,
                MembershipStatus.ACTIVE);

        long activeSubscriptions = subscriptionRepository.countByMembershipOrganizationIdAndStatus(
                organizationId,
                SubscriptionStatus.ACTIVE
        );

        long expiringIn7Days = subscriptionRepository.countByMembershipOrganizationIdAndStatusAndEndDateBetween(
                organizationId,
                SubscriptionStatus.ACTIVE,
                LocalDate.now(),
                LocalDate.now().plusDays(7)
        );

        double totalRevenue = paymentRepository.getTotalRevenueByOrganization(organizationId);

        long couponUsageCount = couponRepository.GetTotalCouponUsageByOrganization(organizationId);

        List<CouponUsageStats> couponStats = couponRepository.getCouponUsageStatsByOrganization(organizationId);
        return  new AnalyticsSummaryResponse(
                totalMembers,
                activeMembers,
                activeSubscriptions,
                totalRevenue,
                expiringIn7Days,
                couponUsageCount,
                couponStats
        );
    }
}

package com.academy.subscription.repository;

import com.academy.subscription.dto.CouponUsageStats;
import com.academy.subscription.entity.Coupon;
import com.academy.subscription.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCodeAndOrganization(String code, Organization organization);

    @Query("""
        SELECT COALESCE(SUM(c.usageCount), 0)
        FROM Coupon c
        WHERE c.organization.id = :organizationId
    """)
    Long GetTotalCouponUsageByOrganization(Long organizationId);

    @Query("""
            SELECT new com.academy.subscription.dto.CouponUsageStats(c.code, c.usageCount)
            FROM Coupon c
            WHERE c.organization.id = :organizationId
            ORDER BY c.usageCount DESC
        """)
    List<CouponUsageStats> getCouponUsageStatsByOrganization(Long organizationId);
}

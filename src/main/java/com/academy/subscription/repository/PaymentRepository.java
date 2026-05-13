package com.academy.subscription.repository;

import com.academy.subscription.entity.Organization;
import com.academy.subscription.entity.Payment;
import com.academy.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("""
        SELECT COALESCE(SUM(p.amount), 0)
            FROM Payment p
            WHERE p.subscription.membership.organization.id = :organizationId
            AND p.status = "SUCCESS"
    """)
    Double getTotalRevenueByOrganization(Long organizationId);
}

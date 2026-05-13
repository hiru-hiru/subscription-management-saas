package com.academy.subscription.repository;

import com.academy.subscription.entity.Membership;
import com.academy.subscription.entity.Subscription;
import com.academy.subscription.entity.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    Optional<Subscription> findByMembershipAndStatus(
            Membership membership,
            SubscriptionStatus status
    );

    long countByMembershipOrganizationIdAndStatus(
            Long organizationId,
            SubscriptionStatus status
    );

    long countByMembershipOrganizationIdAndStatusAndEndDateBetween(
            Long organizationId,
            SubscriptionStatus status,
            LocalDate startDate,
            LocalDate endDate
    );
}

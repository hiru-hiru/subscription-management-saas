package com.academy.subscription.repository;

import com.academy.subscription.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MembershipRepository extends JpaRepository<Membership, Long> {

    List<Membership> findByOrganizationIdAndRole(Long organizationId, Role role);

    List<Membership> findByOrganizationId(Long organizationId);

    Optional<Membership> findByUserAndOrganization(User user, Organization organization);

    long countByOrganizationId(Long organizationId);

    long countByOrganizationIdAndStatus(Long organizationId, MembershipStatus status);
}

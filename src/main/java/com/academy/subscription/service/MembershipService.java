package com.academy.subscription.service;

import com.academy.subscription.dto.CreateMembershipRequest;
import com.academy.subscription.entity.*;
import com.academy.subscription.exception.DuplicateMembershipException;
import com.academy.subscription.exception.ResourceNotFoundException;
import com.academy.subscription.repository.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;

    @Transactional
    public Membership createMembership(CreateMembershipRequest request){

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not found"));

        Organization organization = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

        membershipRepository.findByUserAndOrganization(user, organization)
                .ifPresent(membership -> {
                    throw new DuplicateMembershipException("Membership already exists");
                });

        Membership member = new Membership();

        member.setRole(request.getRole() != null ? request.getRole() : Role.MEMBER);
        member.setOrganization(organization);
        member.setStatus(MembershipStatus.ACTIVE);
        member.setUser(user);

        return membershipRepository.save(member);
    }

}

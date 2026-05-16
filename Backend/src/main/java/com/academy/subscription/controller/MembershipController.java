package com.academy.subscription.controller;

import com.academy.subscription.dto.MembershipSummaryResponse;
import org.springframework.web.bind.annotation.*;

import com.academy.subscription.dto.CreateMembershipRequest;
import com.academy.subscription.entity.Membership;
import com.academy.subscription.service.MembershipService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/memberships")
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;

    @PostMapping
    public Membership createMembership(@RequestBody CreateMembershipRequest request){
        return membershipService.createMembership(request);
    }

    @GetMapping
    public List<MembershipSummaryResponse> getAllMembershipsWithOrganizationId(@RequestParam long organizationId){
        return membershipService.getAllMembersByOrganizationId(organizationId);
    }
}

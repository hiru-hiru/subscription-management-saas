package com.academy.subscription.controller;

import com.academy.subscription.dto.CreateMembershipRequest;
import com.academy.subscription.entity.Membership;
import com.academy.subscription.service.MembershipService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberships")
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;

    @PostMapping
    public Membership createMembership(@RequestBody CreateMembershipRequest request){
        return membershipService.createMembership(request);
    }
}

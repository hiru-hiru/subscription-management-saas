package com.academy.subscription.dto;

import com.academy.subscription.entity.MembershipStatus;
import com.academy.subscription.entity.Role;
import lombok.Data;

@Data
public class MembershipSummaryResponse {
    private long membershipId;
    private long userId;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private MembershipStatus membershipStatus;
}

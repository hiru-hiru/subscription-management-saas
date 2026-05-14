package com.academy.subscription.dto;

import com.academy.subscription.entity.Role;

import lombok.Data;

@Data
public class CreateMembershipRequest {
    private Long userId;
    private Long organizationId;
    private Role role;
}

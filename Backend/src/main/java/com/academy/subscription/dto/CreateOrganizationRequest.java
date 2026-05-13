package com.academy.subscription.dto;

import lombok.Data;

@Data
public class CreateOrganizationRequest {
    private String name;
    private String description;
}

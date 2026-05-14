package com.academy.subscription.dto;

import lombok.Data;

@Data
public class CreatePlanRequest {
    private Long organizationId;
    private String name;
    private Double price;
    private Integer durationInDays;
    private String description;
}

package com.academy.subscription.controller;

import com.academy.subscription.dto.CreateOrganizationRequest;
import com.academy.subscription.entity.Organization;
import com.academy.subscription.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public Organization createOrganization(@RequestBody CreateOrganizationRequest request){
        return organizationService.createOrganization(request);

    }
}

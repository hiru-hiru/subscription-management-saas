package com.academy.subscription.service;

import com.academy.subscription.dto.CreatePlanRequest;
import com.academy.subscription.entity.Organization;
import com.academy.subscription.entity.Plan;
import com.academy.subscription.repository.OrganizationRepository;
import com.academy.subscription.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PlanService {
    private final PlanRepository planRepository;
    private final OrganizationRepository organizationRepository;

    @Transactional
    public Plan createPlan(CreatePlanRequest request){
        Organization organization = organizationRepository.findById(request.getOrganizationId()).orElseThrow(() -> new IllegalArgumentException("Organization not Found"));

        Plan plan = new Plan();

        plan.setDescription(request.getDescription());
        plan.setName(request.getName());
        plan.setPrice(request.getPrice());
        plan.setOrganization(organization);
        plan.setDurationInDays(request.getDurationInDays());

        return planRepository.save(plan);
    }
}

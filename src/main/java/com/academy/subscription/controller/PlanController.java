package com.academy.subscription.controller;

import com.academy.subscription.dto.CreatePlanRequest;
import com.academy.subscription.entity.Plan;
import com.academy.subscription.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plans")
public class PlanController{

    private final PlanService planService;

    @PostMapping
    private Plan createPlan(@RequestBody CreatePlanRequest request){
        return planService.createPlan(request);
    }

}

package com.academy.subscription.controller;

import com.academy.subscription.dto.AnalyticsSummaryResponse;
import com.academy.subscription.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/analytics")
public class AnalyticsController {
    private final AnalyticsService analyticsService;

    @GetMapping("/summary")
    public AnalyticsSummaryResponse getSummary(@RequestParam long organizationId) {
        return analyticsService.getSummary(organizationId);
    }
}

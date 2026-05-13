package com.academy.subscription.controller;

import com.academy.subscription.dto.CreateSubscriptionRequest;
import com.academy.subscription.entity.Subscription;
import com.academy.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public Subscription createSubscription(@RequestBody CreateSubscriptionRequest request){
        return subscriptionService.createSubscription(request);
    }
}

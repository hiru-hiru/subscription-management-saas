package com.academy.subscription.service;

import com.academy.subscription.dto.CreateSubscriptionRequest;
import com.academy.subscription.entity.*;
import com.academy.subscription.repository.MembershipRepository;
import com.academy.subscription.repository.PlanRepository;
import com.academy.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final MembershipRepository membershipRepository;
    private final PlanRepository planRepository;

    @Transactional
    public Subscription createSubscription(CreateSubscriptionRequest request){
        Membership membership = membershipRepository.findById(request.getMembershipId())
                .orElseThrow(() -> new IllegalArgumentException("Membership not found"));

        Plan plan = planRepository.findById(request.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("Plan not found"));

        if(!plan.getOrganization().getId().equals(membership.getOrganization().getId())){
            throw new IllegalArgumentException("Plan does not belong to Organization");
        }

        Optional<Subscription> existingOpt = subscriptionRepository.findByMembershipAndStatus(membership, SubscriptionStatus.ACTIVE);
        LocalDate startDate = LocalDate.now();

        if(existingOpt.isPresent()){
            Subscription existing = existingOpt.get();
            existing.setStatus(SubscriptionStatus.EXPIRED);
            subscriptionRepository.save(existing);

            startDate = existing.getEndDate().plusDays(1);
        }

        Subscription subscription = new Subscription();

        subscription.setCustomPrice(request.getCustomPrice());
        subscription.setPlan(plan);
        subscription.setMembership(membership);
        subscription.setStartDate(startDate);
        subscription.setEndDate(startDate.plusDays(plan.getDurationInDays()));
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        subscription.setDiscountPercentage(request.getDiscountPercentage());

        return subscriptionRepository.save(subscription);

    }

}

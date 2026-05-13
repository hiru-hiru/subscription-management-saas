package com.academy.subscription.service;

import com.academy.subscription.dto.CreatePaymentRequest;
import com.academy.subscription.entity.*;
import com.academy.subscription.exception.ResourceNotFoundException;
import com.academy.subscription.repository.CouponRepository;
import com.academy.subscription.repository.PaymentRepository;
import com.academy.subscription.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.academy.subscription.utility.ValidationUtility.validatePercentage;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final CouponRepository couponRepository;

    @Transactional
    public Payment createPayment(CreatePaymentRequest request){
        Subscription subscription = subscriptionRepository.findById(request.getSubscriptionId())
                .orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));

        Coupon coupon = null;

        if (request.getCouponCode() != null && !request.getCouponCode().isBlank()){
            Organization organization = subscription.getMembership().getOrganization();

            coupon = couponRepository.findByCodeAndOrganization(request.getCouponCode(), organization).orElseThrow(() -> new ResourceNotFoundException("Coupon not found"));

            if (!coupon.canBeUsedNow()) {
                throw new RuntimeException("Coupon is not valid");
            }

            coupon.increaseUsageCount();
        }

        Payment payment = new Payment();

        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus(request.getStatus());
        payment.setCoupon(coupon);
        payment.setSubscription(subscription);

        double amount = (subscription.getCustomPrice() == null ? subscription.getPlan().getPrice() : subscription.getCustomPrice());

        if (subscription.getDiscountPercentage() != null){
            double percentage = subscription.getDiscountPercentage();
            validatePercentage(percentage, "Subscription discount percentage");
            amount = amount * ((100 - percentage)/100);
        }

        if (coupon != null){
            amount = coupon.applyCoupon(amount);
        }

        payment.setAmount(amount);

        return paymentRepository.save(payment);
    }
}

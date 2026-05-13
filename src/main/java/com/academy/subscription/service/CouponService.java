package com.academy.subscription.service;

import com.academy.subscription.dto.CreateCouponRequest;
import com.academy.subscription.entity.Coupon;
import com.academy.subscription.entity.Organization;
import com.academy.subscription.exception.ResourceNotFoundException;
import com.academy.subscription.repository.CouponRepository;
import com.academy.subscription.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final OrganizationRepository organizationRepository;

    @Transactional
    public Coupon createCoupon(CreateCouponRequest request){
        Organization organization = organizationRepository.findById(request.getOrganizationId())
                .orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

        Coupon coupon = new Coupon();

        coupon.setCode(request.getCode());
        coupon.setDiscountType(request.getDiscountType());
        coupon.setMaxUsage(request.getMaxUsage());
        coupon.setDiscountValue(request.getDiscountValue());
        coupon.setOrganization(organization);
        coupon.setValidFrom(request.getValidFrom());
        coupon.setValidUntil(request.getValidUntil());
        coupon.setActive(true);

        return couponRepository.save(coupon);
    }
}

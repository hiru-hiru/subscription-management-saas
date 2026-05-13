package com.academy.subscription.controller;

import com.academy.subscription.dto.CreateCouponRequest;
import com.academy.subscription.entity.Coupon;
import com.academy.subscription.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService couponService;

    @PostMapping
    public Coupon createCoupon(@RequestBody CreateCouponRequest request){
        return couponService.createCoupon(request);
    }
}

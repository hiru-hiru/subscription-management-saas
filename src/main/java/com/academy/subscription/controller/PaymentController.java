package com.academy.subscription.controller;

import com.academy.subscription.dto.CreatePaymentRequest;
import com.academy.subscription.entity.Payment;
import com.academy.subscription.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment createPayment(@RequestBody CreatePaymentRequest request){
        return paymentService.createPayment(request);
    }

}

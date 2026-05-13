package com.academy.subscription.dto;

import com.academy.subscription.entity.DiscountType;
import com.academy.subscription.entity.Organization;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class CreateCouponRequest {
    private DiscountType discountType;
    private Long organizationId;
    private String code;
    private Double discountValue;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private Integer maxUsage;
}

package com.academy.subscription.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.academy.subscription.utility.ValidationUtility.validatePercentage;

@Entity
@Data
@NoArgsConstructor
@Table( name = "coupons",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"organization_id", "code"}
                )
        })
public class Coupon {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupon_seq"
    )
    @SequenceGenerator(
            name = "coupon_seq",
            sequenceName = "coupon_seq",
            allocationSize = 50
    )
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType discountType;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Double discountValue;

    private LocalDate validFrom;
    private LocalDate validUntil;
    private Integer maxUsage;
    private int usageCount = 0;

    @Column(nullable = false)
    private Boolean active;

    public void increaseUsageCount(){
        usageCount++;
    }

    public Double applyCoupon(double amount){
        switch (discountType){
            case DiscountType.FIXED:
                amount -= discountValue;
                break;
            case DiscountType.PERCENTAGE:
                validatePercentage(discountValue, "Coupon discount value");
                amount = amount * (100 - discountValue)/100;
                break;
            default:
                throw new IllegalStateException("Unsupported discount type");
        }
        return Math.max(0,amount);
    }

    public boolean canBeUsedNow(){
        if (!active) return false;

        LocalDate today = LocalDate.now();

        if (validFrom != null && today.isBefore(validFrom) ||
                maxUsage != null && usageCount >= maxUsage ||
                validUntil != null && today.isAfter(validUntil)){

            return false;
        }


        return true;
    }

}

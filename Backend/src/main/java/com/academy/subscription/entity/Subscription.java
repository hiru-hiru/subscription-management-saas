package com.academy.subscription.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subscription_seq"
    )
    @SequenceGenerator(
            name = "subscription_seq",
            sequenceName = "subscription_seq",
            allocationSize = 50
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @OneToMany(mappedBy = "subscription")
    @JsonIgnore
    private List<Payment> payments = new ArrayList<>();

    private LocalDate startDate;
    private LocalDate endDate;
    private Double discountPercentage;
    private Double customPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;
}

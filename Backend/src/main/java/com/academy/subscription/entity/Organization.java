package com.academy.subscription.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organization_seq"
    )
    @SequenceGenerator(
            name = "organization_seq",
            sequenceName = "organization_seq",
            allocationSize = 50
    )
    private Long id;

    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<Membership> memberships;

    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<Plan> plans = new ArrayList<>();

    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<Coupon> coupons = new ArrayList<>();

    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

}

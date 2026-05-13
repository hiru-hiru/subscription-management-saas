package com.academy.subscription.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plans")
@Data
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plan_seq"
    )
    @SequenceGenerator(
            name = "plan_seq",
            sequenceName = "plan_seq",
            allocationSize = 50
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    private String name;
    private Double price;
    private Integer durationInDays;
    private String description;
}

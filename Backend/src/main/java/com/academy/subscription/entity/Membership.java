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
@Table(
        name = "memberships",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "organization_id"})}
)
public class Membership {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "membership_seq"
    )
    @SequenceGenerator(
            name = "membership_seq",
            sequenceName = "membership_seq",
            allocationSize = 50
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MembershipStatus status;

    private LocalDateTime joinedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "membership")
    @JsonIgnore
    private List<Subscription> subscriptions = new ArrayList<>();
}

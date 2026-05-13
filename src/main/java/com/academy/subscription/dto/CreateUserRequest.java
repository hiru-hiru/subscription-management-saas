package com.academy.subscription.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String phone;
}

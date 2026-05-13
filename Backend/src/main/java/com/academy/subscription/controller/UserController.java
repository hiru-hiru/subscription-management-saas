package com.academy.subscription.controller;

import com.academy.subscription.dto.CreateUserRequest;
import com.academy.subscription.entity.User;
import com.academy.subscription.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public User createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

//    @GetMapping()
//    public List<User> getUsers(){
//        System.out.println("Hello");
//        return userRepository.findAll();
//    }

}

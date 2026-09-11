package com.parking.parkly.controller;

import com.parking.parkly.dto.UserRequest;
import com.parking.parkly.dto.UserResponse;
import com.parking.parkly.model.User;
import com.parking.parkly.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(
            @RequestBody User user
            ) {
        return  ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(
             @RequestBody UserRequest request
    ) {
        return ResponseEntity.ok(userService.loginUser(request));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}
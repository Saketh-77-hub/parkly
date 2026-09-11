package com.parking.parkly.service;

import com.parking.parkly.dto.UserRequest;
import com.parking.parkly.dto.UserResponse;
import com.parking.parkly.model.User;
import com.parking.parkly.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }

        User savedUser = userRepository.save(user);

        return mapToUserResponse(savedUser);
    }

    private UserResponse mapToUserResponse(User savedUser) {

        UserResponse response = new UserResponse();

        response.setEmail(savedUser.getEmail());
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());

        return response;
    }

    public UserResponse loginUser(UserRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return mapToUserResponse(user);
    }

    public UserResponse getUserById(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToUserResponse(user);
    }
}

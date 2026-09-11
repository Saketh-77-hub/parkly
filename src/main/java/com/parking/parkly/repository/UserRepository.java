package com.parking.parkly.repository;

import com.parking.parkly.model.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);

}

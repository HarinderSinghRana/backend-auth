package com.auth_service1.ecommerce_backend.service;

import com.auth_service1.ecommerce_backend.dto.user.UserRequest;
import com.auth_service1.ecommerce_backend.dto.user.UserResponse;
import com.auth_service1.ecommerce_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponse registerUser(UserRequest request);
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    Optional<User> findByEmail(String email);

}

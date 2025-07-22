package com.auth_service1.ecommerce_backend.service;

import com.auth_service1.ecommerce_backend.dto.user.UserRequest;
import com.auth_service1.ecommerce_backend.dto.user.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse registerUser(UserRequest request);
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);

}

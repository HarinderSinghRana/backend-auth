package com.auth_service1.ecommerce_backend.service;

import com.auth_service1.ecommerce_backend.dto.UserRequest;
import com.auth_service1.ecommerce_backend.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);

}

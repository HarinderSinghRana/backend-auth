package com.auth_service1.ecommerce_backend.service.impl;

import com.auth_service1.ecommerce_backend.dto.UserRequest;
import com.auth_service1.ecommerce_backend.dto.UserResponse;
import com.auth_service1.ecommerce_backend.entity.User;
import com.auth_service1.ecommerce_backend.repository.UserRepos;
import com.auth_service1.ecommerce_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepos userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = modelMapper.map(request, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserResponse.class);
    }
}

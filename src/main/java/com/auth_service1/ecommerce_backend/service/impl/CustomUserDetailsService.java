package com.auth_service1.ecommerce_backend.service.impl;

import com.auth_service1.ecommerce_backend.entity.User;
import com.auth_service1.ecommerce_backend.repository.UserRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepos userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
//                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name()) // assumes Role enum
                .build();
    }

}

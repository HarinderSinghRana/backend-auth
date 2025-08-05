package com.auth_service1.ecommerce_backend.controller;


import com.auth_service1.ecommerce_backend.dto.auth.AuthRequest;
import com.auth_service1.ecommerce_backend.dto.auth.AuthResponse;
import com.auth_service1.ecommerce_backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(new AuthResponse(token, user.getUsername()));
    }

}

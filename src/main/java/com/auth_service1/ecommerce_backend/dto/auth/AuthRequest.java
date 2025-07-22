package com.auth_service1.ecommerce_backend.dto.auth;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AuthRequest {
    private String email;
    private String password;
}

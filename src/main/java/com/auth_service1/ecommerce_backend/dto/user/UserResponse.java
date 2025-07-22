package com.auth_service1.ecommerce_backend.dto.user;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private String role;

}

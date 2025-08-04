package com.auth_service1.ecommerce_backend.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    private String name;    // incoming; mapped to User.username

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String role;

}

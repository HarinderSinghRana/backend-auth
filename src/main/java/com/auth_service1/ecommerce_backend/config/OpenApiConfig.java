package com.auth_service1.ecommerce_backend.config;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @PostConstruct
    public void log() {
        System.out.println("✅ LOG- OpenApiConfig loaded");
    }

    @Bean
    public OpenAPI customOpenAPI() {
        System.out.println("🛠 OpenApiConfig constructor called");
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .info(new Info()
                        .title("Ecommerce Backend API")
                        .version("1.0.0")
                        .description("API documentation with JWT authentication"))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName,
                                new SecurityScheme()
                                        .name(securitySchemeName)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

}


//@OpenAPIDefinition(
//        info = @io.swagger.v3.oas.annotations.info.Info(title = "E-Commerce API", version = "1.0"),
//        security = @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "bearerAuth") // Default applied to all endpoints
//)
//@io.swagger.v3.oas.annotations.security.SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer",
//        bearerFormat = "JWT"
//)
package com.auth_service1.ecommerce_backend.mapper;

import com.auth_service1.ecommerce_backend.dto.user.UserRequest;
import com.auth_service1.ecommerce_backend.dto.user.UserResponse;
import com.auth_service1.ecommerce_backend.entity.Role;
import com.auth_service1.ecommerce_backend.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T15:12:52-0400",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( request.getName() );
        user.email( request.getEmail() );
        user.password( request.getPassword() );
        if ( request.getRole() != null ) {
            user.role( Enum.valueOf( Role.class, request.getRole() ) );
        }

        return user.build();
    }

    @Override
    public UserResponse toResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        Long id = null;
        String email = null;
        String role = null;

        name = user.getUsername();
        id = user.getId();
        email = user.getEmail();
        if ( user.getRole() != null ) {
            role = user.getRole().name();
        }

        UserResponse userResponse = new UserResponse( id, name, email, role );

        return userResponse;
    }
}

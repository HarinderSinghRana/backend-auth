package com.auth_service1.ecommerce_backend.mapper;

import com.auth_service1.ecommerce_backend.dto.user.UserRequest;
import com.auth_service1.ecommerce_backend.dto.user.UserResponse;
import com.auth_service1.ecommerce_backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
    // adapt source field names if UserRequest uses name vs username
    @Mapping(target = "username", source = "name")
    User toEntity(UserRequest request);

    @Mapping(target = "name", source = "username")
    UserResponse toResponse(User user);
}
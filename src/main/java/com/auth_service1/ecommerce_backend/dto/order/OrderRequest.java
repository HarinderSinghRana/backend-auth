package com.auth_service1.ecommerce_backend.dto.order;

import com.auth_service1.ecommerce_backend.dto.order_item.OrderItemRequest;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    @NotBlank
    @Email
    private String customerEmail;

    @NotEmpty
    private List<OrderItemRequest> items;

}

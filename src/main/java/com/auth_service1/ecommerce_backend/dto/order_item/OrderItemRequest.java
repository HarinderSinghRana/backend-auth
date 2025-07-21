package com.auth_service1.ecommerce_backend.dto.order_item;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemRequest {

    @NotNull
    private Long productId;

    @Min(1)
    private Integer quantity;

}

package com.auth_service1.ecommerce_backend.dto.order_item;

import lombok.Data;

@Data
public class OrderItemResponse {

    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;

}

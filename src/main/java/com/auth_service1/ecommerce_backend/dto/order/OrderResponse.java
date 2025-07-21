package com.auth_service1.ecommerce_backend.dto.order;

import com.auth_service1.ecommerce_backend.dto.order_item.OrderItemResponse;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {

    private Long id;
    private String customerEmail;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItemResponse> items;

}

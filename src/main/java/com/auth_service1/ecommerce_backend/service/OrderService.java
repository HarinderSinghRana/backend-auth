package com.auth_service1.ecommerce_backend.service;

import com.auth_service1.ecommerce_backend.dto.order.OrderRequest;
import com.auth_service1.ecommerce_backend.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {

    void processOrderAsync(Long orderId);
    OrderResponse placeOrder(OrderRequest request);
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderById(Long id);

    List<OrderResponse> getOrdersByUserEmail(String email);

}

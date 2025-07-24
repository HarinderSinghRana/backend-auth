package com.auth_service1.ecommerce_backend.controller;

import com.auth_service1.ecommerce_backend.dto.order.OrderRequest;
import com.auth_service1.ecommerce_backend.dto.order.OrderResponse;
import com.auth_service1.ecommerce_backend.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/process/{id}")
    public ResponseEntity<String> processOrder(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authenticated roles: " + auth.getAuthorities());

        orderService.processOrderAsync(id);
        return ResponseEntity.ok("Order is being processed");
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

}

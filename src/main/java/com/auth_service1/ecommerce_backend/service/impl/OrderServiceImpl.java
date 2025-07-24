package com.auth_service1.ecommerce_backend.service.impl;

import com.auth_service1.ecommerce_backend.dto.order.OrderRequest;
import com.auth_service1.ecommerce_backend.dto.order.OrderResponse;
import com.auth_service1.ecommerce_backend.entity.Order;
import com.auth_service1.ecommerce_backend.entity.OrderItem;
import com.auth_service1.ecommerce_backend.entity.Product;
import com.auth_service1.ecommerce_backend.repository.OrderRepos;
import com.auth_service1.ecommerce_backend.repository.ProductRepos;
import com.auth_service1.ecommerce_backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepos orderRepository;
    private final ProductRepos productRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponse placeOrder(OrderRequest request) {
        Order order = Order.builder()
                .orderDate(LocalDateTime.now())
                .status("PENDING")
                .customerEmail(request.getCustomerEmail())
                .build();

        List<OrderItem> items = request.getItems().stream().map(itemRequest -> {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            return OrderItem.builder()
                    .productId(product.getId())
                    .productName(product.getName())
                    .price(product.getPrice().doubleValue())
                    .quantity(itemRequest.getQuantity())
                    .order(order)
                    .build();
        }).collect(Collectors.toList());

        order.setItems(items);
        Order saved = orderRepository.save(order);

        return modelMapper.map(saved, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return modelMapper.map(order, OrderResponse.class);
    }

    @Async
    public void processOrderAsync(Long orderId){
        System.out.println("Processing order in thread: " + Thread.currentThread().getName());

        // Simulate a time-consuming task
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Order " + orderId + " processed.");
    }

}

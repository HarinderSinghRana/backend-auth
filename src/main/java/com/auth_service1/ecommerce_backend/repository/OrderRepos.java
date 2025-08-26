package com.auth_service1.ecommerce_backend.repository;

import com.auth_service1.ecommerce_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepos extends JpaRepository<Order, Long> {
    List<Order> findByCustomerEmail(String email);
}

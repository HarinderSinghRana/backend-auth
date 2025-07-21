package com.auth_service1.ecommerce_backend.repository;

import com.auth_service1.ecommerce_backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepos extends JpaRepository<Order, Long> {
}

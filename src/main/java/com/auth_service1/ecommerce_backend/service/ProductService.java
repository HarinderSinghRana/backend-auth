package com.auth_service1.ecommerce_backend.service;

import com.auth_service1.ecommerce_backend.dto.product.ProductRequest;
import com.auth_service1.ecommerce_backend.dto.product.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);

}

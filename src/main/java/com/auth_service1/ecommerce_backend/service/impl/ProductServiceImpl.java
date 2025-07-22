package com.auth_service1.ecommerce_backend.service.impl;

import com.auth_service1.ecommerce_backend.dto.product.ProductRequest;
import com.auth_service1.ecommerce_backend.dto.product.ProductResponse;
import com.auth_service1.ecommerce_backend.entity.Product;
import com.auth_service1.ecommerce_backend.repository.ProductRepos;
import com.auth_service1.ecommerce_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepos productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = modelMapper.map(request, Product.class);
        Product saved = productRepository.save(product);
        return modelMapper.map(saved, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductResponse.class);
    }

}

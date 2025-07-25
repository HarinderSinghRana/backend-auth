package com.auth_service1.ecommerce_backend.controller;

import com.auth_service1.ecommerce_backend.service.impl.AsyncOrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private AsyncOrderProcessor asyncOrderProcessor;

    @GetMapping("/async")
    public String testAsync() {
        asyncOrderProcessor.runAsyncTask();
        return "Async started";
    }

}

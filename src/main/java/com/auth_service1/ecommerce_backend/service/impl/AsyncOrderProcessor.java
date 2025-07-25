package com.auth_service1.ecommerce_backend.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncOrderProcessor {

    @Async
    public void runAsyncTask() {
        System.out.println(">>> ASYNC thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(">>> DONE from async");
    }
}
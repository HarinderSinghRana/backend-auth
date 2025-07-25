package com.auth_service1.ecommerce_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EcommerceBackendApplication {

	public static void main(String[] args) {
//		System.out.println("This is a first draft page");
		SpringApplication.run(EcommerceBackendApplication.class, args);
	}

}

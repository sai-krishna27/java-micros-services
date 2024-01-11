package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
@EnableCircuitBreaker
@SpringBootApplication
public class BooksStoreConsumerEurekaRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksStoreConsumerEurekaRibbonHystrixApplication.class, args);
	}

}

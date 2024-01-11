package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
@SpringBootApplication
public class BooksStoreConsumerEurekaRibbonHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksStoreConsumerEurekaRibbonHystrixApplication.class, args);
	}
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) {
		return new TimedAspect(registry);
	}

}

package com.example.demo.proxy;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="book-service-zipkin")
public interface BookServiceProxy {
	
	@Retry(name="book-service-zipkin")
	@CircuitBreaker(name="book-service-zipkin",fallbackMethod = "fallBackOfGetBookById")
	@GetMapping("getBook/{id}")
	public Book getBookById(@PathVariable int id);
	

	
	public default Book fallBackOfGetBookById(int id,Throwable cause) {
		System.out.println("Exception raised is "+cause.getMessage());
		return new Book(id,"101 Windows Phone 7 Apps","sai","978-1-59327-843-4",288,2018);
	}

}

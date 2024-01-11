package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class BookService {
	@Autowired
	RestTemplate restTemplate;
	
	@Retry(name="book-service")
	@CircuitBreaker(name="book-service",fallbackMethod = "fallBackOfBookById")
	public Book getBookById(int id) {
		Book book=restTemplate.getForObject("http://book-service/book/"+id, Book.class);
		return book;
	}
	
	public Book fallBackOfBookById(int id,Throwable cause) {
		System.out.println("the exception occured is -> "+cause.getMessage());
		return new Book(id,"101 Windows Phone 7 Apps","sai","978-1-59327-843-4",288,2018);
	}

}

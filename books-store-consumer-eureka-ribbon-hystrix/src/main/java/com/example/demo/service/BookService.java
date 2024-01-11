package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallBackOfBookById")
	public Book getBookById(int id) {
		Book book=restTemplate.getForObject("http://book-service/book/"+id, Book.class);
		return book;
	}
	
	public Book fallBackOfBookById(int id) {
		return new Book(id,"101 Windows Phone 7 Apps","sai","978-1-59327-843-4",288,2018);
	}

}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Book;

@RestController
@Scope("request")
public class BookController {
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/getBook/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		Book book=restTemplate.getForObject("http://book-service/book/"+id, Book.class);
		return book;
	}
}

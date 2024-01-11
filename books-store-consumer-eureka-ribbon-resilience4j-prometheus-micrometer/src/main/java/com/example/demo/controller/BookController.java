package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import io.micrometer.core.annotation.Timed;

@RestController
@Scope("request")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Timed(value="getBookById.time",description="Time taken to return book")
	@GetMapping("/getBook/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
}

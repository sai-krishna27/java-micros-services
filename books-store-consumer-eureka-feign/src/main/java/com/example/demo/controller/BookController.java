package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.proxy.BookServiceProxy;

@RestController
@Scope("request")
public class BookController {
	
	@Autowired
	private BookServiceProxy proxy;
	
	@GetMapping("getBook/{id}")
	public Book getBookById(@PathVariable int id) {
		return proxy.getBookById(id);
	}
	
	@GetMapping("getBooks")
	public List<Book> getBooks() {
		return proxy.getAllBooks();
	}
}	

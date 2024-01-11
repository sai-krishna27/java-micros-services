package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public static final Logger log=LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookServiceProxy proxy;
	
	@GetMapping("getBookById/{id}")
	public Book getBookById(@PathVariable int id) {
		log.debug("get book by id method with id:"+ id);
		Book book=proxy.getBookById(id);
		log.debug("get book by id method with return books:"+ book);
		return book;
	}
	
	
}	

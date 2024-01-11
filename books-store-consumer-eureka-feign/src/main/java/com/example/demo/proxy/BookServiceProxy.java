package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Book;

@FeignClient("book-service")//movie-booking
public interface BookServiceProxy {
	
	@GetMapping("book/{id}")
	public Book getBookById(@PathVariable int id);
	
	@GetMapping("books")
	public List<Book> getAllBooks();
}

//http://movie-booking/book/2

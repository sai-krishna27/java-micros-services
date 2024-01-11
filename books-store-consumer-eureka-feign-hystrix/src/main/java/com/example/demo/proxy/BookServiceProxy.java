package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Book;
import com.example.demo.fallback.BookServiceFallback;

@FeignClient(name="book-service",fallback = BookServiceFallback.class)
public interface BookServiceProxy {
	
	@GetMapping("book/{id}")
	public Book getBookById(@PathVariable int id);
	
	@GetMapping("books")
	public List<Book> getAllBooks();
}

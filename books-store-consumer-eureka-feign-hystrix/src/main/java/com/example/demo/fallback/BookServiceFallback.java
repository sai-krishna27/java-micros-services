package com.example.demo.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.proxy.BookServiceProxy;

@Service
public class BookServiceFallback implements BookServiceProxy {

	@Override
	public Book getBookById(int id) {
		return new Book(id,"101 Windows Phone 7 Apps","sai","978-1-59327-843-4",288,2018);
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>();
	}

}
 
package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	private int id;
	private String title;
	private String publisher;
	private String isbn;
	private int pages;
	private int year;
	
	public Book(String title, String publisher, String isbn, int pages, int year) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
		this.pages = pages;
		this.year = year;
	}
	
	
}

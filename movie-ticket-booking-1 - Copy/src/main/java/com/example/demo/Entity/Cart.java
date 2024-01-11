package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="email")
	private String email;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Column(name="movie")
	private String movie;

	public Cart(String email, int quantity, float price, String movie) {
		super();
		this.email = email;
		this.quantity = quantity;
		this.price = price;
		this.movie = movie;
	}

	

	
	

}
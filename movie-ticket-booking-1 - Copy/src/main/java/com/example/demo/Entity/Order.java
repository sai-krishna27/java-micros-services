package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bookings")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="movie")
	private String movie;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "email")
	private String email;
	
	@Column(name = "movie_date")
	private String movieData;
	
	@Column(name="movie_time")
	private String movieTime;
	
	@Column(name = "transaction_id")
	private long transactionId;

	public Order(String movie, int quantity, float price, String email, String movieData, String movieTime,
			long transactionId) {
		super();
		this.movie = movie;
		this.quantity = quantity;
		this.price = price;
		this.email = email;
		this.movieData = movieData;
		this.movieTime = movieTime;
		this.transactionId = transactionId;
	}

	
	

}

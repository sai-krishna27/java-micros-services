package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Order;
import com.example.demo.repo.OrderRepo;

@Service
public class OrderService{

	@Autowired 
	OrderRepo OrderRepo;
	
	public String deleteOrderByEmail(String email) {
		OrderRepo.deleteOrderByEmail(email);
		return "all orders with user email - '"+email+"' are deleted";
	}
	
	public Order addOrder(Order order) {
		return OrderRepo.save(order);
	}

	
	public List<Order> getCustomerOrder(String emailId) {
		return OrderRepo.searchByEmail(emailId);
	}
	
	public List<Order> getAllOrder() {
		return OrderRepo.findAll();
	}

	
}

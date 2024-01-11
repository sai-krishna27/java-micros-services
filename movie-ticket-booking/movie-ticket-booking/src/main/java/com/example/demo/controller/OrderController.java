package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.service.OrderService;

@RestController
@Scope(value = "request")
public class OrderController {
	
	@Autowired
	private OrderService orderDao;
	
	@PostMapping("/order")
	public Order addOrder(@RequestBody Order order) {
		return orderDao.addOrder(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderDao.getAllOrder();
	}
	
	@GetMapping("/order/{email}")
	public List<Order> getUserOrders(@PathVariable("email") String email ){
		return orderDao.getCustomerOrder(email);
	}
	
	@DeleteMapping("/order/{email}")
	public String deleteOrdersByEmail(@PathVariable String email) {
		return orderDao.deleteOrderByEmail(email);
	}
}

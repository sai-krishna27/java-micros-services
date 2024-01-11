package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cart;
import com.example.demo.service.CartService;

@RestController
@Scope(value="request")
public class CartController {
	
	@Autowired
	public CartService cartDao;
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartDao.addMoviesToCart(cart);
	}
	
	@GetMapping("/cart/{email}")
	public List<Cart> getCartItems(@PathVariable("email") String email) {
		return cartDao.getCartItemsByEmail(email);
	}
	
	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartDao.updateCart(cart);
	}
	
	@DeleteMapping("/cart/{email}")
	public Boolean deleteCartByEmail(@PathVariable("email") String email) {
		return cartDao.deleteCartByEmail(email);
	}
	
	@DeleteMapping("/cart/{id}")
	public Boolean deleteCartById(@PathVariable("id") int id) {
		return cartDao.deleteCartById(id);
	}
	
	
}
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.repo.CartRepo;

@Service
public class CartService {
	@Autowired
	CartRepo cartRepo;

	public Cart addMoviesToCart(Cart cart) {
		return cartRepo.save(cart);
	}

	public List<Cart> getCartItemsByEmail(String email) {
		return cartRepo.getByEmail(email);
	}
	
	public Cart updateCart(Cart cart) {
		if(cartRepo.findById(cart.getId())!=null) {
			return cartRepo.save(cart);
		}
		else {
			return new Cart();
		}
	}

	public boolean deleteCartById(int cartId) {
		try {
			cartRepo.deleteById(cartId);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean deleteCartByEmail(String email) {
		try {
			cartRepo.deleteByEmail(email);;
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	

}


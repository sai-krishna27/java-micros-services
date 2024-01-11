package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	String query="delete from Cart c where c.email=:email";
	@Transactional 
	@Modifying
	@Query(query)
	public void deleteByEmail(String email);
	
	@Query("from Cart where email=?1")
	public List<Cart> getByEmail(String email);
}
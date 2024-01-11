package com.example.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

	@Query("from Order where email=?1")
	public List<Order> searchByEmail(String email);
	
	String query="delete from Order o where o.email=:email";
	@Transactional 
	@Modifying
	@Query(query)
	public void deleteOrderByEmail(String email);
}

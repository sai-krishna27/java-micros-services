package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	public UserRepo userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}
	
	public User getUserByEmail(String email) {
		return userRepo.getUserByEmail(email);
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public String deleteUser(int id) {
		userRepo.deleteById(id);
		return "user is removed from the database";
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}

}

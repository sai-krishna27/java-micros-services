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

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;

@RestController
@Scope(value = "request")
public class UserController {
	
	@Autowired
	private UserService userDao;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userDao.addUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id){
		return userDao.getUserById(id);
	}
	
	@GetMapping("/userByEmail/{email}")
	public User getUserByEmal(@PathVariable("email") String email){
		return userDao.getUserByEmail(email);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userDao.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") int id){
		return userDao.deleteUser(id);
	}
	
}

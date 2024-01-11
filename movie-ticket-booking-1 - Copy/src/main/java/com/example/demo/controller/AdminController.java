package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Admin;
import com.example.demo.service.AdminService;

@RestController
@Scope(value = "request")
public class AdminController {
	
	@Autowired
	public AdminService adminDao;
	
	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminDao.addAdmin(admin);
	}
	
	@GetMapping("/admin/{email}")
	public Admin getAdminById(@PathVariable("email") String email) {
		return adminDao.getAdminByEmail(email);
	}

}

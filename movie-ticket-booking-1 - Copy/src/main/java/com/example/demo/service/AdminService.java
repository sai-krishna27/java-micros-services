package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	public AdminRepo adminRepo;
	
	public Admin addAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin getAdminByEmail(String email) {
		return adminRepo.findById(email).get();
	}

}
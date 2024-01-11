package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.producer.EmployeeRegistrationProducer;

@RestController
public class EmployeeRegistrationController {
	
	@Autowired
	private EmployeeRegistrationProducer employeeRegistrationProducer;
	
	@PostMapping(value="register")
	public String orderFood(@RequestBody Employee employee) {
		employeeRegistrationProducer.sendMessage(employee);
		return "Message was send successfully";
	}
}

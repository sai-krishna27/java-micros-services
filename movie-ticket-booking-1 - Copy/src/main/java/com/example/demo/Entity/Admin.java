package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	@Id
	@Column(name = "admin_email")
	private String email;
	
	@Column(name = "admin_name")
	private String name;
	
	@Column(name = "admin_password")
	private String password;

	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

}
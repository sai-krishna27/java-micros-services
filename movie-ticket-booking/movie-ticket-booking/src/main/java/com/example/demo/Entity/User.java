package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="u_id")
	private int uid;
	
	@Column(name="u_name")
	private String uname;
	
	@Column(name="u_email",unique = true)
	private String uemail;
	
	@Column(name="u_pass")
	private String upass;
	
	@Column(name="u_phno",unique = true)
	private String uphone;
	
	@Column(name="u_address")
	private String uaddress;

	public User(String uname, String uemail, String upass, String uphone, String uaddress) {
		this.uname = uname;
		this.uemail = uemail;
		this.upass = upass;
		this.uphone = uphone;
		this.uaddress = uaddress;
	}
	
	
	
}

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "m_id")
	private int mid;

	@Column(name = "m_name")
	private String mname;
	
	@Column(name="language")
	private String mlanguage;

	@Column(name = "m_description")
	private String mdescription;
	
	@Column(name = "m_duration")
	private String mduration;

	@Column(name = "m_rating")
	private Float mrating;

	@Column(name = "m_price")
	private Float mprice;

	@Column(name = "m_image")
	private String mimage;

	@Column(name = "m_gerne")
	private String mgerne;

	@Column(name = "m_status")
	private String mstatus;

	public Movie(String mname, String mlanguage, String mdescription, String mduration, Float mrating, Float mprice,
			String mimage, String mgerne, String mstatus) {
		super();
		this.mname = mname;
		this.mlanguage = mlanguage;
		this.mdescription = mdescription;
		this.mduration = mduration;
		this.mrating = mrating;
		this.mprice = mprice;
		this.mimage = mimage;
		this.mgerne = mgerne;
		this.mstatus = mstatus;
	}
	
	
	
}
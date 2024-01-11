package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.Entity.*;
import com.example.demo.repo.*;

import brave.sampler.Sampler;

@EnableEurekaClient
@SpringBootApplication
public class MovieTicketBookingApplication implements CommandLineRunner {

	@Bean
	public Sampler alwaysSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApplication.class, args);
	}
	
	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public MovieRepo movieRepo;
	
	@Autowired
	public AdminRepo adminRepo;
	
	@Autowired
	public OrderRepo orderRepo;
	
	@Autowired
	public CartRepo cartRepo;

	@Override
	public void run(String... args) throws Exception {
		
		userRepo.save(new User("john","john@gmail.com","John@123","7894561231","new york"));
		userRepo.save(new User("tom","tom@gmail.com","tom@123","7894561222","new york"));
		movieRepo.save(new Movie("john wich 4","english","gangster","02:45:32",5.0f,250f,
				"https://static.wikia.nocookie.net/john-wick8561/images/7/7c/Chapterfour.jpeg/revision/latest?cb=20230523074638",
				"action","enable"));
		movieRepo.save(new Movie("john wich 3","english","gangster","02:45:32",5.0f,250f,
				"https://images-na.ssl-images-amazon.com/images/S/pv-target-images/459543e33775972b85d72b253740f3c36c809ce05aaa19b6c1227231877e60e1._RI_TTW_.jpg",
				"action","enable"));
		adminRepo.save(new Admin("admin@gmail.com","admin","Admin@123"));
		orderRepo.save(new Order("john wick 4",2,500f,"john@gmail.com","06-09-2023","15:05:00",568421));
		cartRepo.save(new Cart("john@gmail.com",2,500f,"john wick 4"));
		orderRepo.save(new Order("john wick 3",2,500f,"tom@gmail.com","06-09-2023","15:05:00",568871));
		cartRepo.save(new Cart("tom@gmail.com",2,500f,"john wick 3"));
		
		
	}

}
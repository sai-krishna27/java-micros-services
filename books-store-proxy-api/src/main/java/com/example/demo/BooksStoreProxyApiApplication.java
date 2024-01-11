package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.demo.filter.ErrorFilter;
import com.example.demo.filter.PostFilter;
import com.example.demo.filter.PreFilter;
import com.example.demo.filter.RouteFilter;


@EnableZuulProxy
@SpringBootApplication
public class BooksStoreProxyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksStoreProxyApiApplication.class, args);
	}
	
	@Bean 
	public PreFilter getPreFilter() {
		return new PreFilter();
	}
	
	@Bean 
	public PostFilter getPostFilter() {
		return new PostFilter();
	}
	
	@Bean 
	public RouteFilter getRouteFilter() {
		return new RouteFilter();
	}
	
	@Bean 
	public ErrorFilter getErrorFilter() {
		return new ErrorFilter();
	}
}

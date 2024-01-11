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

import com.example.demo.Entity.Movie;
import com.example.demo.service.MovieService;

@RestController
@Scope(value = "request")
public class MovieController {
	
	@Autowired
	MovieService movieDao;
	
	@GetMapping("/movies")
	public List<Movie> vieAllMovie() {
		return movieDao.getAllMovies();
	}
	
	@GetMapping("/searchMovie/{movie}")
	public List<Movie> serchMovieByKeyword(@PathVariable("movie") String movie) {
		return movieDao.searchMovie(movie);
		
	}
	
	@GetMapping("/getEnabledBooks")
	public List<Movie> getEnabledBooks(){
		return movieDao.getEnabledMovies();
	}
	
	@GetMapping("/sortMoviesByGerne")
	public List<Movie> sortByGerne(){
		return movieDao.getSortedMovies();
	}
	
	
	@GetMapping("/movie/{id}")
	public Movie getMovieById(@PathVariable("id") int id) {
		return movieDao.getMovieById(id);
	}
	
	
	@PostMapping(value = "/addMovie")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieDao.addMovie(movie);
	}
	
	
	@PutMapping(value = "/updateMovie")
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieDao.updateMovieById(movie);
	}
	
	
	@DeleteMapping("/deleteMovieById/{id}")
	public boolean deleteMovieById(@PathVariable("id") int id) {
		return deleteMovieById(id);
			
	}
	
}

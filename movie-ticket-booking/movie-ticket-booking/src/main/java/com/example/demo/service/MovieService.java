package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Movie;
import com.example.demo.repo.MovieRepo;

@Service
public class MovieService {

	@Autowired
	MovieRepo movieRepo;

	public List<Movie> getSortedMovies(){
		return movieRepo.sortMoviesByGerne();
	}
	
	public List<Movie> getEnabledMovies(){
		return movieRepo.getEnabledBooks();
	}
	
	public Movie addMovie(Movie movie) {
		try {
			Movie movieAddResult = movieRepo.save(movie);
			return movieAddResult;
		} catch (Exception e) {
			return new Movie();
		}
	}

	
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
		
	}

    
    public Movie getMovieById(int id) {
        return movieRepo.findById(id).get();
    }

	
	public Movie updateMovieById(Movie movie) {
		if(movieRepo.findById(movie.getMid())!=null) {
			return movieRepo.save(movie);
		}
		else {
			return new Movie();
		}
	}

	
	public boolean deleteMovieById(int movieId) {
		try {
			movieRepo.deleteById(movieId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public List<Movie> searchMovie(String movie) {
		String search="%"+movie+"%";
		return movieRepo.searchMovie(search);
	}


}

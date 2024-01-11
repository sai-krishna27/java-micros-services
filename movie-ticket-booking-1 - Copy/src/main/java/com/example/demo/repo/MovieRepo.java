package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer>{
	
	@Query("from Movie order by mgerne asc")
	public List<Movie> sortMoviesByGerne();
	
	@Query("from Movie where mstatus='enable'")
	public List<Movie> getEnabledBooks();
	

	@Query("from Movie where mname like ?1 or language like ?1 or mgerne like ?1")
	public List<Movie> searchMovie(String movie);
	

}

package com.dss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dss.model.Movie;
import com.dss.repository.MovieRepository;


@RestController
@RequestMapping("/api")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/movies")
	public List<Movie> findAllMovies(){
		List<Movie> movie = movieRepository.findAll();
		movie.forEach(System.out::println);
		return movie;
	}

	@GetMapping("/movies/{id}")
	public Movie findMoviebyId(@PathVariable(value ="id") Long movieid){
		Optional<Movie> optionalMovie = movieRepository.findById(movieid);
		Movie movie = optionalMovie.get();
		System.out.println(movie);
		return movie;
	}
	
	@PostMapping("/movies")
	public Movie createMovie(@RequestBody Movie movie) {
		System.out.println("Inserting " +movie);
		Movie movieReturned = movieRepository.save(movie);
		System.out.println("Inserted " +movie);
		return movieReturned;
	}
	
	@PutMapping("/movies/{id}")
	public Movie updateMovie(@PathVariable(value ="id") Long movieid, @RequestBody Movie movie) {
		Optional<Movie> optionalMovie = movieRepository.findById(movieid);
		Movie movieFromDB = optionalMovie.get();
		movieFromDB.setMovie_title(movie.getMovie_title());
		movieFromDB.setMovie_cost(movie.getMovie_cost());
		movieFromDB.setMovie_year(movie.getMovie_year());
		Movie movieReturned = movieRepository.save(movieFromDB);
		System.out.println("Updated " +movie);
		return movieReturned;
	}

	@DeleteMapping("/movies/{id}")
	public boolean deleteMovie(@PathVariable(value = "id") long movieid) {
		movieRepository.deleteById(movieid);
		System.out.println("Deleted " +movieid);
		return true;
	}
}

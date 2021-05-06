package com.DSS.repository;

import java.util.List;
import java.util.Optional;

import com.DSS.model.Movie;

public interface MoviesJDBCRepository {
	public List<Movie> findAll() ;

	public int insertMovie(Movie movie);

	public Movie findById(long movieid);
	
	public int deleteMovieById(long movieid);

	public int deleteAllMovies();

	public int updateMovie(Movie movie);
}

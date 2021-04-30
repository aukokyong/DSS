package com.lab1.service;

import java.util.ArrayList;

import com.lab1.model.Movie;
import com.lab1.repository.MovieRepository;
import com.lab1.repository.MovieRepositoryImpl;

public class MovieServiceImpl implements MovieService {

	MovieRepository movierepo = null;
	
	public MovieServiceImpl() {
		movierepo = new MovieRepositoryImpl();
	}
	
	public ArrayList <Movie> getMovies()
	{
		return movierepo.getMovies();
	}
	
	public void getMoviesviaID(int movieid)
	{
		movierepo.getMoviesFromDBviaID(movieid);
	}
	
	public int insertMovie(Movie movie)
	{
		int rowsInserted = movierepo.insertMovie(movie);
		return rowsInserted;
	}
	
	public int updateMovie(Movie movie)
	{
		int rowsUpdated = movierepo.updateMovie(movie);
		return rowsUpdated;
	}
	
	public int deleteMovie(int movieid)
	{
		int rowsDeleted = movierepo.deleteMovie(movieid);
		return rowsDeleted;
	}
	
}

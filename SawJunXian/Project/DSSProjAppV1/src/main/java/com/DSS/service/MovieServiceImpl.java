package com.DSS.service;

import java.util.ArrayList;

import com.DSS.model.Movie;
import com.DSS.repository.MovieRepository;
import com.DSS.repository.MovieRepositoryImpl;

public class MovieServiceImpl implements MovieService {

	MovieRepository movierepo = null;
	
	public MovieServiceImpl() {
		movierepo = new MovieRepositoryImpl();
	}
	
	public ArrayList <Movie> getMovies()
	{
		return movierepo.getMovies();
	}
	
	public Movie getMovieviaID(int movieid)
	{
		return movierepo.getMovieviaID(movieid);
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

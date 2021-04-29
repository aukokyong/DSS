package com.lab1.ui;

import com.lab1.model.Movie;
import com.lab1.service.MovieService;
import com.lab1.service.MovieServiceImpl;

public class App {

	private static void getMovies()
	{
		MovieService movieservice = new MovieServiceImpl();
		movieservice.getMovies();
	}
	
	private static void getMoviesviaID()
	{
		MovieService movieservice = new MovieServiceImpl();
		movieservice.getMoviesviaID(2);
	}
	
	private static void insertMovies()
	{
		MovieService movieservice = new MovieServiceImpl();
		movieservice.insertMovie(new Movie(5,"Wrong Turn 5", 18, 2016));
	}
	
	private static void updateMovie()
	{
		MovieService movieservice = new MovieServiceImpl();
		movieservice.updateMovie(new Movie(5,"Wrong Turn 6", 19, 2019));
	}
	
	private static void deleteMovie()
	{
		MovieService movieservice = new MovieServiceImpl();
		movieservice.deleteMovie(5);
	}
	public static void main(String[] args) {
//		insertMovies();
//		updateMovie();
//		deleteMovie();
//		getMovies();
		getMoviesviaID();
	}

}

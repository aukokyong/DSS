package com.lab1.ui;

import java.util.ArrayList;

import com.lab1.model.Movie;
import com.lab1.service.MovieService;
import com.lab1.service.MovieServiceImpl;

public class App {

	private static void getMovies()
	{
		MovieService movieservice = new MovieServiceImpl();
		ArrayList<Movie> movies = new ArrayList();
		movies = movieservice.getMovies();
		for(Movie m :movies)
		{
			System.out.print(m.getMovie_id() + "\t");
			System.out.print(m.getMovie_title() + "\t");
			System.out.print("$" + m.getMovie_cost() + "\t");
			System.out.print(m.getMovie_year() + "\t\n");
		}
	}
	
	private static void getMoviesviaID()
	{
		MovieService movieservice = new MovieServiceImpl();
		Movie m = movieservice.getMovieviaID(1);
		System.out.print(m.getMovie_id() + "\t");
		System.out.print(m.getMovie_title() + "\t");
		System.out.print("$" + m.getMovie_cost() + "\t");
		System.out.print(m.getMovie_year() + "\t\n");
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

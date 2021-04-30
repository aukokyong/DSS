package com.lab1.service;

import java.util.ArrayList;

import com.lab1.model.Movie;

public interface MovieService {
	public ArrayList <Movie> getMovies();
	public int insertMovie(Movie Movie);
	public int updateMovie(Movie movie);
	public int deleteMovie(int movieid);
	public void getMoviesviaID(int movieid);
}

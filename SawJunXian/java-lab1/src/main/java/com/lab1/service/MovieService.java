package com.lab1.service;

import com.lab1.model.Movie;

public interface MovieService {
	public void getMovies();
	public int insertMovie(Movie Movie);
	public int updateMovie(Movie movie);
	public int deleteMovie(int movieid);
	public void getMoviesviaID(int movieid);
}

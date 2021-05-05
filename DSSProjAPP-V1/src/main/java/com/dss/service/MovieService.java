package com.dss.service;

import java.util.ArrayList;

import com.dss.model.Movie;

public interface MovieService {
	public ArrayList <Movie> getMovies();
	public int insertMovie(Movie Movie);
	public int updateMovie(Movie movie);
	public int deleteMovie(int movieid);
	public Movie getMovieviaID(int movieid);
}

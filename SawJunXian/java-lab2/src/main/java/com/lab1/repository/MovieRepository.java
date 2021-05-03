package com.lab1.repository;

import java.util.ArrayList;

import com.lab1.model.Movie;

public interface MovieRepository {
	public ArrayList <Movie> getMovies();
	public Movie getMovieviaID(int movieid);
	public int insertMovie(Movie Movie);
	public int updateMovie(Movie movie);
	public int deleteMovie(int movieid);
}

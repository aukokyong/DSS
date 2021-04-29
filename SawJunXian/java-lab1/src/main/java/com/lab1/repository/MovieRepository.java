package com.lab1.repository;

import com.lab1.model.Movie;

public interface MovieRepository {
	public void getMoviesFromDB();
	public void getMoviesFromDBviaID(int movieid);
	public int insertMovie(Movie Movie);
	public int updateMovie(Movie movie);
	public int deleteMovie(int movieid);
}

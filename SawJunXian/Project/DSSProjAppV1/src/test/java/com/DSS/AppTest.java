package com.DSS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.DSS.model.Movie;
import com.DSS.service.MovieService;
import com.DSS.service.MovieServiceImpl;
public class AppTest {
	
	
	@Test
	public void testGetAllMovies()
	{
		MovieService movieservice = new MovieServiceImpl();
		ArrayList<Movie> movies = movieservice.getMovies();
		assertEquals(movies.size(), movieservice.getMovies().size());
	}
	
	@Test
	public void testinsertMovie()
	{
		MovieService movieservice = new MovieServiceImpl();
		assertEquals(1, movieservice.insertMovie(new Movie(8,"Wrong Turn 5", 18, 2016)));
	}
	
	@Test
	public void testDeleteMovie()
	{
		MovieService movieservice = new MovieServiceImpl();
		assertEquals(1, movieservice.deleteMovie(8));
	}
	
	@Test
	public void testUpdateMovie()
	{
		MovieService movieservice = new MovieServiceImpl();
		Movie updateMovie = new Movie(10,"Wrong Turn 10", 18, 2011);
		assertEquals(1,movieservice.updateMovie(updateMovie));
	}
	
	@Test
	public void testGetMovieById()
	{
		MovieService movieservice = new MovieServiceImpl();
		Movie newmovie = movieservice.getMovieviaID(1);
		assertEquals(1, newmovie.getMovie_id());
	}
	
	
}

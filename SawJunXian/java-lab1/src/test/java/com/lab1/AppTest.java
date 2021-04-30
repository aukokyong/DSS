package com.lab1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.lab1.model.Movie;
import com.lab1.service.MovieService;
import com.lab1.service.MovieServiceImpl;
public class AppTest {

	@Test
	public void Testing()
	{
		Movie movie1 = new Movie(9,"Wrong Turn 5", 18, 2016);
		Movie movie2 = new Movie(10,"Wrong Turn 5", 18, 2016);
		MovieService movieservice = new MovieServiceImpl();
		assertEquals(1, movieservice.insertMovie(movie2));
		assertEquals(1, movieservice.updateMovie(movie1));
	}
	
	@Test
	public void testGetAllMovies()
	{
		MovieService movieservice = new MovieServiceImpl();
		assertEquals(5, movieservice.getMovies().size());
	}
}

package com.DSS.model;


public class Movie {
	

	private Long movieId;
	private String movieTitle;
	private int movieCost;
	private int movieYear;
	
	public Movie()
	{
		
	}

	public Movie(Long movieId, String movieTitle,  int movieCost, int movieYear) {
		super();
		this.movieId = movieId;
		this.movieCost = movieCost;
		this.movieTitle = movieTitle;
		this.movieYear = movieYear;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieCost() {
		return movieCost;
	}

	public void setMovieCost(int movieCost) {
		this.movieCost = movieCost;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieCost=" + movieCost + ", movieYear="
				+ movieYear + "]";
	}
	
	
	
}

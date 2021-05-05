package com.DSS.model;

public class Movie {
	
	private int movie_id;
	private String movie_title;
	private int movie_cost;
	private int movie_year;
	
	public Movie()
	{
		
	}
	
	public Movie(int movie_id, String movie_title, int movie_cost, int movie_year) {
		super();
		this.movie_id = movie_id;
		this.movie_title = movie_title;
		this.movie_cost = movie_cost;
		this.movie_year = movie_year;
	}
	

	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public int getMovie_cost() {
		return movie_cost;
	}
	public void setMovie_cost(int movie_cost) {
		this.movie_cost = movie_cost;
	}
	public int getMovie_year() {
		return movie_year;
	}
	public void setMovie_year(int movie_year) {
		this.movie_year = movie_year;
	}

	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_title=" + movie_title + ", movie_cost=" + movie_cost
				+ ", movie_year=" + movie_year + "]";
	}
	

}

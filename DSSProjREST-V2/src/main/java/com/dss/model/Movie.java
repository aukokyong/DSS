package com.dss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long movieId;
	
	@Column(name ="movie_title")
	private String movieTitle;
	@Column(name ="movie_cost")
	private int movieCost;
	@Column(name ="movie_year")
	private int movieYear;
	
	public Movie()
	{
		
	}

	public Movie(Long movieId, String movieTitle, int movieCost, int movieYear) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieCost = movieCost;
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

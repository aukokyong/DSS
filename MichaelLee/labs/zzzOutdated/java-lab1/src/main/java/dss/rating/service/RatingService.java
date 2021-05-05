package main.java.dss.rating.service;

import java.util.ArrayList;

import main.java.dss.rating.model.Rating;

public interface RatingService {
	public abstract ArrayList getRatings();
	public abstract Rating selectRating(int ratingId);
	public abstract int insertRating(Rating rating);
	public abstract int updateRating(Rating rating);
	public abstract int deleteRating(int ratingId);
}
package com.dss.repository;

import java.util.ArrayList;

import com.dss.model.Rating;


public interface RatingRepository {
	public abstract ArrayList getRatings();
	public abstract Rating selectRating(int ratingId);
	public abstract int insertRating(Rating rating);
	public abstract int updateRating(Rating rating);
	public abstract int deleteRating(int ratingId);
}

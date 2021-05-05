package com.dss.repository;

import java.util.ArrayList;

import com.dss.model.Review;


public interface ReviewRepository {
	public abstract ArrayList getReviews();
	public abstract Review selectReview(int reviewId);
	public abstract int insertReview(Review review);
	public abstract int updateReview(Review review);
	public abstract int deleteReview(int reviewId);
}

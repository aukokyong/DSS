package com.dss.service;

import java.util.ArrayList;

import com.dss.model.Review;

public interface ReviewService {
	public abstract ArrayList getReviews();
	public abstract Review selectReview(int reviewId);
	public abstract int insertReview(Review review);
	public abstract int updateReview(Review review);
	public abstract int deleteReview(int reviewId);
}
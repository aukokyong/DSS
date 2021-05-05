package com.dss.service;

import java.util.ArrayList;

import com.dss.model.Review;
import com.dss.repository.ReviewRepository;
import com.dss.repository.ReviewRepositoryImpl;

public class ReviewServiceImpl implements ReviewService {
	
	ReviewRepository ReviewRepository = null;
	public ReviewServiceImpl() {
		System.out.println("ReviewService instantiated ....");
		ReviewRepository = new ReviewRepositoryImpl();
	}

	@Override
	public ArrayList getReviews() {
		return ReviewRepository.getReviews();
	}

	@Override
	public int insertReview(Review review) {
		return ReviewRepository.insertReview(review);
	}

	@Override
	public int updateReview(Review review) {
		return ReviewRepository.updateReview(review);
	}

	@Override
	public int deleteReview(int reviewId) {
		return ReviewRepository.deleteReview(reviewId);
	}

	@Override
	public Review selectReview(int reviewId) {
		return ReviewRepository.selectReview(reviewId);
	}

}

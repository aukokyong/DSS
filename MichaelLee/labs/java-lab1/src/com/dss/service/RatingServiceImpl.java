package com.dss.service;

import java.util.ArrayList;

import com.dss.model.Rating;
import com.dss.repository.RatingRepository;
import com.dss.repository.RatingRepositoryImpl;

public class RatingServiceImpl implements RatingService {
	
	RatingRepository RatingRepository = null;
	public RatingServiceImpl() {
		System.out.println("RatingService instantiated ....");
		RatingRepository = new RatingRepositoryImpl();
	}

	@Override
	public ArrayList getRatings() {
		return RatingRepository.getRatings();
	}

	@Override
	public int insertRating(Rating rating) {
		return RatingRepository.insertRating(rating);
	}

	@Override
	public int updateRating(Rating rating) {
		return RatingRepository.updateRating(rating);
	}

	@Override
	public int deleteRating(int ratingId) {
		return RatingRepository.deleteRating(ratingId);
	}

	@Override
	public Rating selectRating(int ratingId) {
		return RatingRepository.selectRating(ratingId);
	}

}

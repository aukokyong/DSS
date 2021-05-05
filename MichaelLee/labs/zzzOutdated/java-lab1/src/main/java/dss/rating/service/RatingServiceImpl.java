package main.java.dss.rating.service;

import java.util.ArrayList;

import main.java.dss.rating.model.Rating;
import main.java.dss.rating.repository.RatingRepository;
import main.java.dss.rating.repository.RatingRepositoryImpl;

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

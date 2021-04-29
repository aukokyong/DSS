package com.dss.ui;

import com.dss.model.Rating;
import com.dss.service.RatingService;
import com.dss.service.RatingServiceImpl;

public class CRUDApp {

	public static void main(String[] args) {
		System.out.println("Build a CRUD.....");
		getAllRatings();
		insertRating(4, 5);
		selectRating(2);
		updateRating(2, 3);
		deleteRating(2);
	}

	private static void deleteRating(int ratingId) {
		RatingService ratingService = new RatingServiceImpl();
		ratingService.deleteRating(ratingId);
	}

	private static void updateRating(int ratingId, int ratingScore) {
		RatingService ratingService = new RatingServiceImpl();
		Rating rating = new Rating(ratingScore, ratingScore);
		ratingService.updateRating(rating);
	}

	private static void selectRating(int ratingId) {
		RatingService ratingService = new RatingServiceImpl();
		ratingService.selectRating(ratingId);
	}

	private static void insertRating(int ratingId, int ratingScore) {
		RatingService ratingService = new RatingServiceImpl();
		Rating rating = new Rating(ratingScore, ratingScore);
		ratingService.insertRating(rating);
	}

	private static void getAllRatings() {
		RatingService ratingService = new RatingServiceImpl();
		ratingService.getRatings();
	}

}

package com.dss.ui;

import java.util.ArrayList;
import java.util.stream.IntStream;

import com.dss.model.Rating;
import com.dss.service.RatingService;
import com.dss.service.RatingServiceImpl;

public class CRUDApp {

	public static void main(String[] args) {
		System.out.println("Build a CRUD.....");
		getAllRatings();
		insertRating(4, 5);
		selectRating(2);
		updateRating(2, 1);
		deleteRating(2);
	}

	private static void deleteRating(int ratingId) {
		RatingService ratingService = new RatingServiceImpl();
		int success = 0;
		success = ratingService.deleteRating(ratingId);
		if (success != 0) {
			System.out.println("Rating " + ratingId + " has been deleted");
		} else {
			System.out.println("Deletion of rating failed");
		}
	}

	private static void updateRating(int ratingId, int ratingScore) {
		RatingService ratingService = new RatingServiceImpl();
		Rating rating = new Rating(ratingScore, ratingScore);
		int success = 0;
		success = ratingService.updateRating(rating);
		if (success != 0) {
			System.out.println("Rating " + ratingId + " has been updated");
		} else {
			System.out.println("Update of rating failed");
		}
	}

	private static void selectRating(int ratingId) {
		RatingService ratingService = new RatingServiceImpl();
		Rating rating = ratingService.selectRating(ratingId);
		System.out.println(ratingId + " -> " + rating.getRatingScore());
	}

	private static void insertRating(int ratingId, int ratingScore) {
		RatingService ratingService = new RatingServiceImpl();
		Rating rating = new Rating(ratingScore, ratingScore);
		int success = 0;
		success = ratingService.insertRating(rating);
		if (success != 0) {
			System.out.println("Rating " + ratingId + " has been inserted");
		} else {
			System.out.println("Insertion of rating failed");
		}
	}

	private static void getAllRatings() {
		RatingService ratingService = new RatingServiceImpl();
		ArrayList<Rating> ratings = ratingService.getRatings();
		IntStream.range(0, ratings.size())
			.forEach(index -> {
		    System.out.println(ratings.get(index).getRatingId() + " -> " + ratings.get(index).getRatingScore());
		});
	}

}

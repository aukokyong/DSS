package com.dss.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.stream.IntStream;

import com.dss.model.Review;
import com.dss.service.ReviewService;
import com.dss.service.ReviewServiceImpl;

public class ReviewApp {
	
	public static void main(String[] args) {
		System.out.println("Build a CRUD.....");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date date1 = sdf.parse("2021-05-03 00:00:00");
			java.util.Date date2 = sdf.parse("2018-05-01 00:00:00");
			Timestamp datesql1 = new java.sql.Timestamp(date1.getTime());
			Timestamp datesql2 = new java.sql.Timestamp(date2.getTime());
			getAllReviews();
			insertReview(4, datesql1, "this film aint good", 1);
			selectReview(2);
			updateReview(2, datesql2, "this film is good", 5);
			deleteReview(4);
			getAllReviews();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void deleteReview(int reviewId) {
		ReviewService ratingService = new ReviewServiceImpl();
		int success = 0;
		success = ratingService.deleteReview(reviewId);
		if (success != 0) {
			System.out.println("Review " + reviewId + " has been deleted");
		} else {
			System.out.println("Deletion of review failed");
		}
	}

	private static void updateReview(int reviewId, Timestamp date, String description, int ratingScore) {
		ReviewService ratingService = new ReviewServiceImpl();
		Review review = new Review(reviewId, date, description, ratingScore);
		int success = 0;
		success = ratingService.updateReview(review);
		if (success != 0) {
			System.out.println("Review " + reviewId + " has been updated");
		} else {
			System.out.println("Update of review failed");
		}
	}

	private static void selectReview(int reviewId) {
		ReviewService ratingService = new ReviewServiceImpl();
		Review review = ratingService.selectReview(reviewId);
		System.out.println(reviewId + " -> " + review.getRating());
	}

	private static void insertReview(int reviewId, Timestamp date, String description, int ratingScore) {
		ReviewService ratingService = new ReviewServiceImpl();
		Review review = new Review(reviewId, date, description, ratingScore);
		int success = 0;
		success = ratingService.insertReview(review);
		if (success != 0) {
			System.out.println("Review " + reviewId + " has been inserted");
		} else {
			System.out.println("Insertion of review failed");
		}
	}

	private static void getAllReviews() {
		ReviewService ratingService = new ReviewServiceImpl();
		ArrayList<Review> reviews = ratingService.getReviews();
		IntStream.range(0, reviews.size())
			.forEach(index -> {
		    System.out.println(reviews.get(index).getReviewId() + " -> " + reviews.get(index).getRating());
		});
	}

}

package main.java.dss.review.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Review extends Object implements Serializable{
	private int reviewId;
	private Timestamp date;
	private String description;
	private int rating;
	
	public Review(int reviewId, Timestamp date, String description, int rating) {
		this.setReviewId(reviewId);
		this.setDate(date);
		this.setDescription(description);
		this.setRating(rating);
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp timestamp) {
		this.date = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}

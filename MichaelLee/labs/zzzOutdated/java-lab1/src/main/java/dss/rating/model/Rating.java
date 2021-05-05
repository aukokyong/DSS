package main.java.dss.rating.model;

import java.io.Serializable;

public class Rating extends Object implements Serializable{
	private int ratingId;
	private int ratingScore;
	
	public Rating(int ratingId, int ratingScore) {
		this.setRatingId(ratingId);
		this.setRatingScore(ratingScore);
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getRatingScore() {
		return ratingScore;
	}

	public void setRatingScore(int ratingScore) {
		this.ratingScore = ratingScore;
	}
}

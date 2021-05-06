package dss.review.model;

import java.sql.Timestamp;

public class Review {
	private Long reviewId;
	private Timestamp datePosted;
	private String description;
	private int rating;
	
	public Review(Long reviewId, Timestamp date, String description, int rating) {
		this.setReviewId(reviewId);
		this.setDatePosted(date);
		this.setDescription(description);
		this.setRating(rating);
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Timestamp getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Timestamp timestamp) {
		this.datePosted = timestamp;
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

	@Override
	public String toString() {
		return "Review{" + "reviewId=" + reviewId + ", datePosted='" + datePosted + '\'' + ", description='"
				+ description + '\'' + ", rating=" + rating + '}';
	}
}
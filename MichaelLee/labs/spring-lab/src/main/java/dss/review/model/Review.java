package dss.review.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "REVIEWS")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;
	private Timestamp datePosted;
	private String description;
	private Long rating;

	public Review() {
	}

	public Review(Timestamp datePosted, String description, Long rating) {
		this.datePosted = datePosted;
		this.description = description;
		this.rating = rating;
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

	public void setDatePosted(Timestamp datePosted) {
		this.datePosted = datePosted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review{" + "reviewId=" + reviewId + ", datePosted='" + datePosted + '\'' + ", description='"
				+ description + '\'' + ", rating=" + rating + '}';
	}
}
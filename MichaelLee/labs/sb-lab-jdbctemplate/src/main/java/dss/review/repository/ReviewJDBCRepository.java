package dss.review.repository;

import java.util.List;
import java.util.Optional;

import dss.review.model.Review;

public interface ReviewJDBCRepository {

	List<Review> findAll();

	Optional<Review> findById(long prodcutId);

	int insert(Review review);

	int update(Review review);

	int deleteById(long reviewId);

	int deleteAll();

}
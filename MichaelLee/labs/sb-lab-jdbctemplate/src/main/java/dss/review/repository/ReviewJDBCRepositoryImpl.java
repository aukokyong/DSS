package dss.review.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dss.review.model.Review;

@Repository
public class ReviewJDBCRepositoryImpl implements ReviewJDBCRepository   {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class ReviewRowMapper implements RowMapper<Review> {

		@Override
		public Review mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Review review = new Review(null, null, null, 0);
			review.setReviewId(resultSet.getLong(1));
			review.setDatePosted(resultSet.getTimestamp(2));
			review.setDescription(resultSet.getString(3));
			review.setRating(resultSet.getInt(4));
			return review;
		}

	}

	@Override
	public List<Review> findAll() {
		ReviewRowMapper reviewRowMapper = new ReviewRowMapper();
		List<Review> reviewsList = jdbcTemplate.query("SELECT * FROM REVIEWS", reviewRowMapper);
		return reviewsList;
	}

	@Override
	public Optional<Review> findById(long prodcutId) {
		BeanPropertyRowMapper<Review> beanPropertyRowMapper = new BeanPropertyRowMapper<Review>(Review.class);
		Review review = jdbcTemplate.queryForObject("SELECT * FROM REVIEWS where review_id = ?",
				beanPropertyRowMapper);
		return Optional.of(review);
	}

	@Override
	public int insert(Review review) {
		return jdbcTemplate.update(
				"insert into REVIEWS (review_id, date_posted, description, rating) values(?, ?, ?, ?)",
				new Object[] { review.getReviewId(), review.getDatePosted(), review.getDescription(),
						review.getRating() });
	}

	@Override
	public int update(Review review) {
		return jdbcTemplate.update(
				"update REVIEWS " + " set date_posted = ?, description = ?, rating = ? " + " where review_id = ?",
				new Object[] { review.getDatePosted(), review.getDescription(), review.getRating(),
						review.getReviewId() });
	}

	@Override
	public int deleteById(long reviewId) {
		return jdbcTemplate.update("delete from REVIEWS where review_id=?", new Object[] { reviewId });
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("delete from REVIEWS");
	}

}

package test.java.dss.review.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import main.java.dss.review.model.Review;
import main.java.dss.review.service.ReviewService;
import main.java.dss.review.service.ReviewServiceImpl;

public class ReviewTest {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Test
	public void TestGetAllReviews() {
		ReviewService reviewService = new ReviewServiceImpl();
		assertEquals(2, reviewService.getReviews().size());
	}

	@Test
	public void TestInsertReview() throws ParseException {
		Date date1 = sdf.parse("2021-05-03 00:00:00");
		Timestamp datesql1 = new java.sql.Timestamp(date1.getTime());
		System.out.println(date1);
		Review review1 = new Review(10, datesql1, "this film rocks", 5);
		ReviewService reviewService = new ReviewServiceImpl();
		assertEquals(1, reviewService.insertReview(review1));
	}

	@Test
	public void TestUpdateReview() throws ParseException {
		Date date2 = sdf.parse("2018-05-01 00:00:00");
		Timestamp datesql2 = new java.sql.Timestamp(date2.getTime());
		Review review2 = new Review(10, datesql2, "this film aint too gd", 2);
		ReviewService reviewService = new ReviewServiceImpl();
		assertEquals(1, reviewService.updateReview(review2));
	}

	@Test
	public void TestSelectReview() {
		int reviewId = 10;
		ReviewService reviewService = new ReviewServiceImpl();
		assertNotEquals(null, reviewService.selectReview(reviewId));
	}

	@Test
	public void TestDeleteReview() {
		int reviewId = 10;
		ReviewService reviewService = new ReviewServiceImpl();
		assertEquals(1, reviewService.deleteReview(reviewId));
	}
}

package test.java.dss.rating.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import main.java.dss.rating.model.Rating;
import main.java.dss.rating.service.RatingService;
import main.java.dss.rating.service.RatingServiceImpl;

public class RatingTest {
	
	@Test
	public void TestGetAllRatings() {
		RatingService ratingService = new RatingServiceImpl();
		assertEquals(7, ratingService.getRatings().size());
	}

	@Test
	public void TestInsertRating() {
		Rating rating1 = new Rating(9, 5);
		RatingService ratingService = new RatingServiceImpl();
		assertEquals(1, ratingService.insertRating(rating1));
	}

	@Test
	public void TestUpdateRating() {
		Rating rating1 = new Rating(9, 2);
		RatingService ratingService = new RatingServiceImpl();
		assertEquals(1, ratingService.updateRating(rating1));
	}

	@Test
	public void TestSelectRating() {
		int ratingId = 9;
		RatingService ratingService = new RatingServiceImpl();
		assertNotEquals(null, ratingService.selectRating(ratingId));
	}

	@Test
	public void TestDeleteRating() {
		int ratingId = 9;
		RatingService ratingService = new RatingServiceImpl();
		assertEquals(1, ratingService.deleteRating(ratingId));
	}
}

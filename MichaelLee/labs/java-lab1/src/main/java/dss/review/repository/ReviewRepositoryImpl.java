package main.java.dss.review.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.dss.review.model.Review;
import main.java.dss.review.repository.util.MySQLConnectionUtil;

public class ReviewRepositoryImpl implements ReviewRepository {

	@Override
	public ArrayList<Review> getReviews() {
		ArrayList<Review> reviews = new ArrayList<Review>();
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM REVIEWS");
			while (resultSet.next()) {
				Review review = new Review(0, null, null, 0);
				review.setReviewId(resultSet.getInt(1));
				review.setDate(resultSet.getTimestamp(2));
				review.setDescription(resultSet.getString(3));
				review.setRating(resultSet.getInt(4));
				reviews.add(review);
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return reviews;
	}

	@Override
	public int insertReview(Review review) {
		int rowInserted = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REVIEWS VALUES(?,?,?,?)");
			preparedStatement.setInt(1, review.getReviewId());
			preparedStatement.setTimestamp(2, review.getDate());
			preparedStatement.setString(3, review.getDescription());
			preparedStatement.setInt(4, review.getRating());
			rowInserted = preparedStatement.executeUpdate();
			System.out.println("Inserted : " + rowInserted);
			return rowInserted;
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return rowInserted;
	}

	@Override
	public int updateReview(Review review) {
		int rowUpdated = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE REVIEWS SET DATE_POSTED = ?, DESCRIPTION = ?, RATING = ? WHERE REVIEW_ID = ?");
			preparedStatement.setTimestamp(1, review.getDate());
			preparedStatement.setString(2, review.getDescription());
			preparedStatement.setInt(3, review.getRating());
			preparedStatement.setInt(4, review.getReviewId());
			rowUpdated = preparedStatement.executeUpdate();
			System.out.println("Updated : " + rowUpdated);
			return rowUpdated;
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return rowUpdated;
	}


	@Override
	public int deleteReview(int reviewId) {
		int rowDeleted = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM REVIEWS WHERE REVIEW_ID = ?");
			preparedStatement.setInt(1, reviewId);
			rowDeleted = preparedStatement.executeUpdate();
			System.out.println("Deleted : " + rowDeleted);
			return rowDeleted;
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return rowDeleted;
	}

	@Override
	public Review selectReview(int reviewId) {
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM REVIEWS WHERE REVIEW_ID = ?");
			preparedStatement.setInt(1, reviewId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Review review = new Review(0, null, null, 0);
				review.setReviewId(resultSet.getInt(1));
				review.setDate(resultSet.getTimestamp(2));
				review.setDescription(resultSet.getString(3));
				review.setRating(resultSet.getInt(4));
				return review;
			} else {
				System.out.println("Record Not Found...");
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return null;
	}
	
}

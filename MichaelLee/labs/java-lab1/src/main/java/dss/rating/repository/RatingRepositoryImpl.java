package main.java.dss.rating.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import main.java.dss.rating.model.Rating;
import main.java.dss.rating.repository.util.MySQLConnectionUtil;

public class RatingRepositoryImpl implements RatingRepository {

	@Override
	public ArrayList<Rating> getRatings() {
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM RATINGS");
			while (resultSet.next()) {
				Rating rating = new Rating(0, 0);
				rating.setRatingId(resultSet.getInt(1));
				rating.setRatingScore(resultSet.getInt(2));
				ratings.add(rating);
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return ratings;
	}

	@Override
	public int insertRating(Rating rating) {
		int rowInserted = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO RATINGS VALUES(?,?)");
			preparedStatement.setInt(1, rating.getRatingId());
			preparedStatement.setInt(2, rating.getRatingScore());
			rowInserted = preparedStatement.executeUpdate();
			System.out.println("Inserted : " + rowInserted);
			return rowInserted;
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return rowInserted;
	}

	@Override
	public int updateRating(Rating rating) {
		int rowUpdated = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE RATINGS SET RATING_SCORE = ? WHERE RATING_ID = ?");
			preparedStatement.setInt(1, rating.getRatingScore());
			preparedStatement.setInt(2, rating.getRatingId());
			rowUpdated = preparedStatement.executeUpdate();
			System.out.println("Updated : " + rowUpdated);
			return rowUpdated;
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return rowUpdated;
	}


	@Override
	public int deleteRating(int ratingId) {
		int rowDeleted = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM RATINGS WHERE RATING_ID = ?");
			preparedStatement.setInt(1, ratingId);
			rowDeleted = preparedStatement.executeUpdate();
			System.out.println("Deleted : " + rowDeleted);
			return rowDeleted;
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return rowDeleted;
	}

	@Override
	public Rating selectRating(int ratingId) {
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM RATINGS WHERE RATING_ID = ?");
			preparedStatement.setInt(1, ratingId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Rating rating = new Rating(0, 0);
				rating.setRatingId(resultSet.getInt(1));
				rating.setRatingScore(resultSet.getInt(2));
				return rating;
			} else {
				System.out.println("Record Not Found...");
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return null;
	}
	
}

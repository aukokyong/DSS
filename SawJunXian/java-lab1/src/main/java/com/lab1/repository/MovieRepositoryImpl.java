package com.lab1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lab1.model.Movie;
import com.lab1.repository.util.MySQLConnectionUtil;
import com.lab1.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository{

	public void getMoviesFromDB() {

		try {
		Connection connection = MySQLConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM MOVIE");
		System.out.println("ID \t Title \t Cost \t Year");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print("$" + resultSet.getString(3) + "\t");
				System.out.println(resultSet.getString(4));
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}

	}
	
	public void getMoviesFromDBviaID(int movieid)
	{
		try {
		Connection connection = MySQLConnectionUtil.getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MOVIE WHERE MOVIE_ID = ?");
		stmt.setInt(1, movieid);
		System.out.println("ID \t Title \t Cost \t Year");
		ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt(1) + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print("$" + resultSet.getString(3) + "\t");
				System.out.println(resultSet.getString(4));
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	}
	
	public int insertMovie(Movie movie) {

		int noOfRowsInserted = 0;
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO MOVIE VALUES(?,?,?,?)");
			stmt.setInt(1, movie.getMovie_id());
			stmt.setString(2, movie.getMovie_title());
			stmt.setInt(3, movie.getMovie_cost());
			stmt.setInt(4, movie.getMovie_year());
			noOfRowsInserted = stmt.executeUpdate();
			System.out.println("Rows inserted: " + noOfRowsInserted);
			
		}
		 catch (SQLException exception) {
				System.out.println(exception);
		}
		return noOfRowsInserted;
	}
	
	public int updateMovie(Movie movie)
	{

		int noOfRowsUpdated = 0;
		
		try {
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE MOVIE SET MOVIE_TITLE = ? , MOVIE_RATE = ?, MOVIE_YEAR = ? WHERE MOVIE_ID = ?");
			stmt.setString(1, movie.getMovie_title());
			stmt.setInt(2, movie.getMovie_cost());
			stmt.setInt(3, movie.getMovie_year());
			stmt.setInt(4, movie.getMovie_id());
			noOfRowsUpdated = stmt.executeUpdate();
			}catch (SQLException exception) {
			System.out.println(exception);
		}
		return noOfRowsUpdated;
	}
	
	public int deleteMovie(int movieid)
	{
		int noOfRowsDeleted = 0;
		try
		{
			Connection connection = MySQLConnectionUtil.getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM MOVIE WHERE MOVIE_ID = ?");
			stmt.setInt(1, movieid);
			noOfRowsDeleted = stmt.executeUpdate();
		}catch(SQLException exception){
			System.out.println(exception);
		}
		return noOfRowsDeleted;
	}
}

package com.DSS.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DSS.model.Movie;

import com.DSS.repository.util.MySQLConnectionUtil;

public class MovieRepositoryImpl implements MovieRepository{

	public ArrayList <Movie> getMovies() {
		ArrayList <Movie> movies = new ArrayList<Movie>();
		try {
		Connection connection = MySQLConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM MOVIE");
			while (resultSet.next()) {
				Movie movie = new Movie();
				movie.setMovie_id(resultSet.getInt(1));
				movie.setMovie_title(resultSet.getString(2));
				movie.setMovie_cost(resultSet.getInt(3));
				movie.setMovie_year(resultSet.getInt(4));
				movies.add(movie);
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return movies;

	}
	
	public Movie getMovieviaID(int movieid)
	{
		Movie movie = new Movie();
		try {
		Connection connection = MySQLConnectionUtil.getConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM MOVIE WHERE MOVIE_ID = ?");
		stmt.setInt(1, movieid);
		ResultSet resultSet = stmt.executeQuery();
	
			while(resultSet.next())
			{
				movie.setMovie_id(resultSet.getInt(1));
				movie.setMovie_title(resultSet.getString(2));
				movie.setMovie_cost(resultSet.getInt(3));
				movie.setMovie_year(resultSet.getInt(4));
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return movie;
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

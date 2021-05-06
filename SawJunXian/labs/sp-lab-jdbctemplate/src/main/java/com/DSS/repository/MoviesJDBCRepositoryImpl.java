package com.DSS.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.DSS.model.Movie;


@Repository
public class MoviesJDBCRepositoryImpl implements MoviesJDBCRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	class MovieRowMapper implements RowMapper<Movie> {

		@Override
		public Movie mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setMovieId(resultSet.getLong(1));
			movie.setMovieCost(resultSet.getInt(2));
			movie.setMovieTitle(resultSet.getString(3));
			movie.setMovieYear(resultSet.getInt(4));
			return movie;
		}

	}
	
	
	@Override
	public List<Movie> findAll() {
		List<Movie> movieList = jdbcTemplate.query("SELECT * FROM movies", new MovieRowMapper());
		return movieList;
	}
	

	@Override
	public Movie findById(long movieid) {
//		BeanPropertyRowMapper<Movie> beanPropertyRowMapper = new BeanPropertyRowMapper<Movie>(Movie.class);
		Movie movie = jdbcTemplate.queryForObject("SELECT * FROM movies where movie_id = ?",
				new Object[] {movieid}, new MovieRowMapper());
		return movie;
		}
	
	@Override
	public int insertMovie(Movie movie) {
		return jdbcTemplate.update(
				"insert into movies (movie_id, movie_cost, movie_title, movie_year) values(?, ?, ?, ?)",
				new Object[] {
						movie.getMovieId(), movie.getMovieCost(), movie.getMovieTitle(),movie.getMovieYear()
						});
	}
	

	@Override
	public int updateMovie(Movie movie) {
		return jdbcTemplate.update("UPDATE MOVIES SET movie_cost = ? , movie_title = ? , movie_year = ? WHERE movie_id = ?",
				new Object[] { movie.getMovieCost(), movie.getMovieTitle(),movie.getMovieYear(), movie.getMovieId()});
	}
	
	@Override
	public int deleteMovieById(long movieid) {
		return jdbcTemplate.update("DELETE FROM MOVIES WHERE movie_id = ?",
				new Object[] {movieid});
	}
	
	@Override
	public int deleteAllMovies() {
		return jdbcTemplate.update("DELETE FROM MOVIES");
	}
	
}

package com.dss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dss.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	public abstract List<Movie> findMovieByMovieTitle(String movieTitle);

	public abstract List<Movie> findMovieByMovieYear(int movieYear);
}

package com.DSS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DSS.model.Movie;
import com.DSS.repository.MoviesJDBCRepositoryImpl;


@SpringBootApplication
public class MoviesApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MoviesJDBCRepositoryImpl movieJDBCRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.error("INSERT MOVIES -> {}", movieJDBCRepository.insertMovie(new Movie(7L, 11, "Joker", 2019)));
		logger.error("UPDATING MOVIE -> {}",movieJDBCRepository.updateMovie(new Movie(1L, "Conjuring 3",12 , 2020)));
		logger.error("All MOVIES -> {}", movieJDBCRepository.findAll());
		logger.error("MOVIE BY ID -> {}", movieJDBCRepository.findById(2));
//		logger.error("DELETE MOVIE -> {}", movieJDBCRepository.deleteMovieById(7));
	}

}

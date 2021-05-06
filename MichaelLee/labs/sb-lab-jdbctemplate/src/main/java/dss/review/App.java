package dss.review;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dss.review.model.Review;
import dss.review.repository.ReviewJDBCRepository;


@SpringBootApplication
public class App implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReviewJDBCRepository reviewJDBCRepository;
	
	public static void main(String[] args) {
		System.out.println("MAIN BEGIN ");
		SpringApplication.run(App.class, args);
		System.out.println("MAIN END");
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = sdf.parse("2021-05-03 00:00:00");
		Timestamp datesql1 = new java.sql.Timestamp(date1.getTime());
		Date date2 = sdf.parse("2018-05-01 00:00:00");
		Timestamp datesql2 = new java.sql.Timestamp(date2.getTime());
		logger.error("DELETING All REVIEWS -> {}", reviewJDBCRepository.deleteAll());
		logger.error("Inserting -> {}",
				reviewJDBCRepository.insert(new Review(1L, datesql1, "this film rocks", 5)));
		logger.error("Inserting -> {}",
				reviewJDBCRepository.insert(new Review(2L, datesql2, "this film aint too gd", 2)));

		logger.error("All REVIEWS -> {}", reviewJDBCRepository.findAll());
		logger.error("Update 2L -> {}", reviewJDBCRepository.update(new Review(2L, datesql1, "I think this film is GREAT", 5)));

		logger.error("All REVIEWS -> {}", reviewJDBCRepository.findAll());
		reviewJDBCRepository.deleteById(2L);

		logger.error("All REVIEWS -> {}", reviewJDBCRepository.findAll());
	}

}

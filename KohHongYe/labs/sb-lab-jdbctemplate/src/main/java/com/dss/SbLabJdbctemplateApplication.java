package com.dss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dss.model.Actor;
import com.dss.repository.ActorJDBCRepository;


@SpringBootApplication
public class SbLabJdbctemplateApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ActorJDBCRepository actorJDBCRepository;

	public static void main(String[] args) {
		System.out.println("MAIN BEGIN ");
		SpringApplication.run(SbLabJdbctemplateApplication.class, args);
		System.out.println("MAIN END");
	}

	@Override
	public void run(String... args) throws Exception {
		char gender = 'M';
		logger.error("DELETING All ACTORS -> {}", actorJDBCRepository.deleteAll());
		logger.error("Inserting -> {}",
				actorJDBCRepository.insert(new Actor(1, "Brad","Pitt",gender,44)));
		logger.error("Inserting -> {}",
				actorJDBCRepository.insert(new Actor(2, "Tom","Cruise",gender,50)));

		logger.error("All ACTORS -> {}", actorJDBCRepository.findAll());
		logger.error("Update 2L -> {}", actorJDBCRepository.update(new Actor(2, "Tom","Cruising",'M',50)));

		logger.error("All ACTORS -> {}", actorJDBCRepository.findAll());
		actorJDBCRepository.deleteById(2L);

		logger.error("All ACTORS -> {}", actorJDBCRepository.findAll());
	}

}

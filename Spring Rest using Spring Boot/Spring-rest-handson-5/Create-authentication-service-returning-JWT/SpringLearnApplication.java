package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Starting Spring Learn Application...");
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Application Started Successfully!");
		LOGGER.info("Authentication endpoint: http://localhost:8090/spring-learn/authenticate");
		LOGGER.info("Test with: curl -u user:pwd http://localhost:8090/spring-learn/authenticate");
	}
}

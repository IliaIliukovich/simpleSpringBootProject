package com.telran.simplespringbootproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringBootProjectApplication {

	private static final Logger logger = LogManager.getLogger(SimpleSpringBootProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootProjectApplication.class, args);

		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
	}

}

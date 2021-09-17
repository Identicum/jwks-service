package com.rs.poc.jwksservice;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class JwksApplication {

	private static final Logger logger = getLogger(JwksApplication.class);

	public static void main(String[] args) {
		logger.info("Starting JwksApplication");
		SpringApplication.run(JwksApplication.class, args);
	}

}

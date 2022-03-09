package com.externalApi.EA;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.security.PublicKey;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EaApplication {
	private Logger logger = LogManager.getLogger(EaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EaApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

package com.judysocute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories( basePackages = "com.judysocute.repository" )
public class MyCmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCmsApplication.class, args);
	}
}

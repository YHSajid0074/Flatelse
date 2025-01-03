package com.agiles.flatelse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlatelseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatelseApplication.class, args);
	}

}

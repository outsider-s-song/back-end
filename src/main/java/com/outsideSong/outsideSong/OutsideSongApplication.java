package com.outsideSong.outsideSong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OutsideSongApplication {
	public static void main(String[] args) {
		SpringApplication.run(OutsideSongApplication.class, args);
	}
}

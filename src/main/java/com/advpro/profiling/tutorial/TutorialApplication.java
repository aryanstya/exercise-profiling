package com.advpro.profiling.tutorial;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TutorialApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(DemoApplication.class);
		sa.run(args);
	}

	@RestController
	public static class WarInitializerController {

		@GetMapping("/")
		public String handler() {
			return "Srping ok!";
		}
	}

}

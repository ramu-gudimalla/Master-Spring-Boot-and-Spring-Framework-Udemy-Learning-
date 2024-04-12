package com.springtutorial.todowebapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(TodoWebApplication.class, args);
	}

	//https://localhost:3000 to 8080
	//Cross Origin Requests
	//Allow all requests only from https://localhost:3000
	@Bean
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public WebMvcConfigurer corsConfigure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("*");
			}
		};
	}
}

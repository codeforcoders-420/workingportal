package com.test.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@ComponentScan(basePackages = {"com.test.spring.boot", "com.test.spring.boot.config", "com.test.spring.boot.controller","com.test.spring.boot.handler","com.test.spring.boot.readfile"})  // Include your controller and service packages
@Scope("prototype")
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

}

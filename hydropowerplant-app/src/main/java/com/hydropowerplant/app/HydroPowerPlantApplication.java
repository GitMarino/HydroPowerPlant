package com.hydropowerplant.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HydroPowerPlantApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HydroPowerPlantApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(HydroPowerPlantAppConfig.class);
	}

}

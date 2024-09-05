package com.koo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koo.controller.HelloController;

@Configuration
public class ControllerConfig {
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}

}

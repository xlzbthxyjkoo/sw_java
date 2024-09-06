package com.koo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HelloController {
	@ResponseBody
	@GetMapping("/")
	public String hello() {
		return "hello, Spring Boot!";
	}

}

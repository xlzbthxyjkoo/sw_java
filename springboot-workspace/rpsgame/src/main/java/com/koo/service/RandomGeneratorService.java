package com.koo.service;

import org.springframework.stereotype.Service;

import com.koo.enums.RockPaperScissors;

@Service
public class RandomGeneratorService {

	public RockPaperScissors getRockPaperScissors() {
		return RockPaperScissors.randomRps();
	}
}

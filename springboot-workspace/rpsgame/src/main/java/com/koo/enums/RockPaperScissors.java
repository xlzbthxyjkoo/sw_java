package com.koo.enums;

import java.util.Random;

public enum RockPaperScissors {
	ROCK("바위"), PAPER("보"), SCISSORS("가위");
	
	private String commentary;
	
	private RockPaperScissors(String commentary) {
		this.commentary = commentary;
	}
	
	public String getCommentary() {
		return commentary;
	}
	
	private static final Random RAND = new Random();
	
	public static RockPaperScissors randomRps() {
		RockPaperScissors[] rpsArray = values();
		return rpsArray[RAND.nextInt(rpsArray.length)];
	}
}

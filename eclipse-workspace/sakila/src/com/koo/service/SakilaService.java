package com.koo.service;

import java.util.Scanner;

public class SakilaService {
	private Scanner scanner;
	private JobFactory factory;
	
	public SakilaService(JobFactory factory) {
		this.factory = factory;
	}
	
	public void doService() {
		scanner = new Scanner(System.in);
		String inputString;
		
		while(true) {
			System.out.println("Select Menu");
			System.out.println("====================");
			System.out.println("a. Films by genre");
			System.out.println("b. Titles by actor");
			System.out.println("c. Stores by title");
			System.out.println("q. Quit");
			System.out.print("> ");
			inputString = scanner.nextLine();
			
			//인터페이스 사용 Gof- Strategy
			SakilaWork work = factory.createJob(inputString, scanner);
			if(work != null) {
				work.getInfo();
				work = null;
			}
			System.out.println();
			
		}
	}

}

package com.koo.service;

import java.util.Scanner;

public class JobFactory {
	public SakilaWork createJob(String job, Scanner scanner) {
		SakilaWork sakilaWork = null;
		
		if(job.equals("a")) {
			sakilaWork = new FilmsByGenre(scanner);
		} 
		else if(job.equals("b")) {
			sakilaWork = new TitlesByActor(scanner);
		}
		else if(job.equals("c")) {
			sakilaWork = new StoresByTitle(scanner);
		}
		else if(job.equals("q")) {
			System.out.println("bye");
			scanner.close();
			System.exit(0);
		}
		else {
			System.out.println("Wrong selection");
		}
		return sakilaWork;
	}

}

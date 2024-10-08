package com.koo.service;

import java.util.List;
import java.util.Scanner;

import com.koo.dao.SakilaDao;
import com.koo.model.TitleActor;

public class TitlesByActor implements SakilaWork{
	private Scanner scanner;
	
	public TitlesByActor(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void getInfo() {
		String fullName, firstName, lastName;
		System.out.println("First-Name Last-Name: ");
		fullName = scanner.nextLine();
		//space 기준으로 앞에, 뒤에
		firstName = fullName.split("\\s+")[0];
		lastName = fullName.split("\\s+")[1];
		
		SakilaDao sakila = SakilaDao.INSTANCE;
		List<TitleActor> titles = sakila.getTitleByActor(firstName, lastName);
		if(titles.size() == 0) {
			System.out.println("No data found!");
		} else {
			for(TitleActor title: titles) {
				System.out.print(title.firstName());
				System.out.print(" ");
				System.out.print(title.lastName());
				System.out.print(" ");
				System.out.print(title.title());
				System.out.print(" ");
				System.out.print(title.releaseYear());
				System.out.print(" ");
				System.out.println(title.rentalrate());
			}
			System.out.println();
		}
		
	}
	
	public void getTitlesByActor() {
		
	}

}

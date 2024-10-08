package com.koo.service;

import java.util.List;
import java.util.Scanner;

import com.koo.dao.SakilaDao;
import com.koo.model.Film;

public class FilmsByGenre implements SakilaWork{
	private Scanner scanner;
	
	public FilmsByGenre(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void getInfo() {
		System.out.print("genre: ");
		String genre = scanner.nextLine();
		
		SakilaDao sakila = SakilaDao.INSTANCE;
		List<Film> films = sakila.getFilms(genre);
		if(films.size() == 0) {
			System.out.println("No data found!");
		} else {
			for(Film film: films) {
				System.out.print(film.filmId());
				System.out.print(" ");
				System.out.print(film.title());
				System.out.print(" ");
				System.out.print(film.genre());
				System.out.print(" ");
				System.out.print(film.releaseYear());
				System.out.print(" ");
				System.out.println(film.langueage());
			}
			System.out.println();
		}
		
	}
	
	public void getFilmsByGenre() {
		
	}

}

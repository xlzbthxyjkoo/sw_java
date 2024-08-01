package com.koo.service;

import java.util.List;
import java.util.Scanner;

import com.koo.dao.SakilaDao;
import com.koo.model.Store;

public class StoresByTitle implements SakilaWork {
	private Scanner scanner;
	
	public StoresByTitle(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void getInfo() {
		
		System.out.print("title: ");
		String title = scanner.nextLine();
		
		SakilaDao sakila = SakilaDao.INSTANCE;
		List<Store> stores = sakila.getStoresByTitle(title);
		if(stores.size() == 0) {
			System.out.println("No data found!");
		} else {
			for(Store store: stores) {
				System.out.print(store.title());
				System.out.print(" ");
				System.out.print(store.storeId());
				System.out.print(" ");
				System.out.print(store.firstName());
				System.out.print(" ");
				System.out.print(store.lastName());
				System.out.print(" ");
				System.out.print(store.address());
				System.out.print(" ");
				System.out.println(store.cnt());
			}
			System.out.println();
		}
		
	}
	
	public void getStoresByTitler() {
		
	}

}

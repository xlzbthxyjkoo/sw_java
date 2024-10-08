package com.koo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koo.model.Film;
import com.koo.model.Store;
import com.koo.model.TitleActor;

public enum SakilaDao {
	INSTANCE;
	
	private Connection conn;
	private ResultSet rSet; 
	private PreparedStatement pStmt;
	private CallableStatement cstmt;
	
	private String url = "jdbc:mysql://localhost:3306/sakila?serverTimeZone=UTC";
	private String username = "koo";
	private String password = "1234";
	
	private void getConnection() {
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private void closeConnection() {
		try {
			if(rSet != null)
				rSet.close();
			if(pStmt != null)
				pStmt.close();
			if(conn != null)
				conn.close();
			if(cstmt != null)
				cstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Film> getFilms(String genre) {
		List<Film> films = new ArrayList<>();
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		//append 할 때 , 아니면 맨 뒤에 한 칸씩 공백 넣기
		sb.append("select FL.film_id, FL.title,CG.name as genre");
		sb.append(", FL.release_year, L.name as language ");
		sb.append("from film FL join film_category FC on FL.film_id = FC.film_id ");
		sb.append("join category CG on FC.category_id = CG.category_id ");
		sb.append("join language L on FL.language_id = L.language_id ");
		sb.append("where CG.name = ?");
		
		String sql = sb.toString();		
		
		try {
			
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  "action");
			rSet = pStmt.executeQuery();
			Film film;
			
			while(rSet.next()) {
				film = new Film(rSet.getLong(1), rSet.getString(2), rSet.getString(3), rSet.getLong(4),
						rSet.getString(5));
				films.add(film);
				
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}	
		return films;
	}
	
	public List<TitleActor> getTitleByActor(String firstName, String lastName) {
		List<TitleActor> titles = new ArrayList<>();
		getConnection();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select AC.first_name, AC.last_name, FL.title");
		sb.append(", FL.release_year, FL.rental_rate ");
		sb.append("from actor AC join film_actor FA on AC.actor_id = FA.actor_id ");
		sb.append("join film FL on FA.film_id = FL.film_id ");
		sb.append("where AC.first_name = ? and AC.last_name = ? ");
		sb.append("order by FL.title;");
		
		String sql = sb.toString();	
		
		try {
			
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,  firstName);
			pStmt.setString(2,  lastName);
			rSet = pStmt.executeQuery();
			TitleActor title;
			
			while(rSet.next()) {
				title = new TitleActor(rSet.getString(1), rSet.getString(2), rSet.getString(3), rSet.getLong(4),
						rSet.getDouble(5));
				titles.add(title);
				
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}	
		return titles;
	}
	
	public List<Store> getStoresByTitle(String title) {
		List<Store> stores = new ArrayList<Store>(); 
		getConnection();
		
		try {
			cstmt = conn.prepareCall("call SP_GET_STORE(?)");
			cstmt.setString(1, title);
			rSet = cstmt.executeQuery();	
			
			Store store;
			while(rSet.next()) {
				store = new Store(rSet.getString(1), rSet.getLong(2), rSet.getString(3),
						rSet.getString(4), rSet.getString(5), rSet.getLong(6));
				stores.add(store);
			}
	            
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}	
		
		return stores;
		
	}
}

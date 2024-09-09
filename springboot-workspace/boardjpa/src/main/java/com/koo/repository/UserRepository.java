package com.koo.repository;

import com.koo.model.BoardUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BoardUser, Long>{
	
}


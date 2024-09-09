package com.koo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo.model.BoardUser;

public interface UserRepository extends JpaRepository<BoardUser, Long>{
	
	Optional<BoardUser> findByUsername(String username);
	
}


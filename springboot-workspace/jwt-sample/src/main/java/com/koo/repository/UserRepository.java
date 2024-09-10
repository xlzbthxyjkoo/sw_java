package com.koo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User getByUid(String uid);
}

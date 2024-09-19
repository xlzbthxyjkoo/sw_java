package com.koo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByAlias(final String alias);
}

package com.koo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koo.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}

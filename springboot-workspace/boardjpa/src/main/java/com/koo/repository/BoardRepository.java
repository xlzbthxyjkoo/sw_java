package com.koo.repository;


import com.koo.model.NoticeBoard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<NoticeBoard, Integer>{
	
}

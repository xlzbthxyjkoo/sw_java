package com.koo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koo.controller.BoardController;
import com.koo.model.BoardDao;
import com.koo.model.NoticeBoard;
import com.koo.service.BoardService;

@Configuration
public class BoardConfig {
	@Bean
	public NoticeBoard noticeBoard() {
		return new NoticeBoard();
	}
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	@Bean
	public BoardService boardService() {
		return new BoardService(boardDao());
	}
	
	@Bean
	public BoardController boardController() {
		return new BoardController(boardService(), noticeBoard());
	}

}

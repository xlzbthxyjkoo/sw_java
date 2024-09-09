package com.koo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo.model.Board;
import com.koo.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/get/{num}")
	public Board getArticle(@PathVariable("num") int articleNo) throws Exception {
		Board board = boardService.getArticle(articleNo);
		
		return board;
	}
}

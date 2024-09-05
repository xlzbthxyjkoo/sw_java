package com.koo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo.model.NoticeBoard;
import com.koo.service.BoardService;

@RestController
@RequestMapping("/api")
public class RestSvcController {
	private NoticeBoard noticeBoard;
	private BoardService boardService;
	
	Logger logger = LoggerFactory.getLogger("com.koo.controller.RestSvcController");
	
	public RestSvcController(NoticeBoard noticeBoard, BoardService boardService) {
		super();
		this.noticeBoard = noticeBoard;
		this.boardService = boardService;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello, world!";
	}
	
	@GetMapping("/article/{num}")
	public NoticeBoard getArticle(@PathVariable("num") int articleNo) {
		noticeBoard = boardService.viewArticle(articleNo);
		return noticeBoard;
	}
	

}

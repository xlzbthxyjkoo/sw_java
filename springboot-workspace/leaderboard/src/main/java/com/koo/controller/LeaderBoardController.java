package com.koo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo.domain.LeaderBoardRow;
import com.koo.service.LeaderBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/leaders")
public class LeaderBoardController {
	private final LeaderBoardService leaderBoardService;
	
	@GetMapping
	public List<LeaderBoardRow> getLeaderBoard() {
		log.info("Retrieving leaderboard!!");
		return leaderBoardService.getCurrentLeaderBoard();
	}

}

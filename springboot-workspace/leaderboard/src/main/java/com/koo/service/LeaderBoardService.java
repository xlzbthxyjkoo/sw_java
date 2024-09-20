package com.koo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koo.domain.LeaderBoardRow;
import com.koo.repository.ScoreCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaderBoardService {
	private final ScoreCardRepository scoreCardRepository;
	
	public List<LeaderBoardRow> getCurrentLeaderBoard() {
		return scoreCardRepository.findFirst10();
	}
}

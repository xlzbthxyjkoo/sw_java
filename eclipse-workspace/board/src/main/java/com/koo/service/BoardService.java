package com.koo.service;

import java.util.List;

import com.koo.model.BoardDao;
import com.koo.model.NoticeBoard;

public class BoardService {
	private final BoardDao boardDao;

	public BoardService(BoardDao boardDao) {
		super();
		this.boardDao = boardDao;
	}
	
	public List<NoticeBoard> listArticles() {
		List<NoticeBoard> articleList = boardDao.selectAllArticles();
		return articleList;
	}
	
	public void addArticle(NoticeBoard noticeBoard) {
		boardDao.insertArticle(noticeBoard);
	}
	
	public NoticeBoard viewArticle(int articleNo) {
		NoticeBoard article = boardDao.selectArticle(articleNo);
		return article;
	}

	public void editArticle(NoticeBoard noticeBoard) {
		boardDao.updateArticle(noticeBoard);
	}
	
	public void removeArticle(int articleNo) {
		boardDao.deleteArticle(articleNo);
	}

}

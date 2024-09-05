package com.koo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koo.model.NoticeBoard;
import com.koo.service.BoardService;

@Controller
@RequestMapping("/notice")
public class BoardController {
	private final BoardService boardService;
	private NoticeBoard noticeBoard;
	
	private List<NoticeBoard> articleList;
	
	public BoardController(BoardService boardService, NoticeBoard noticeBoard) {
		super();
		this.boardService = boardService;
		this.noticeBoard = noticeBoard;
	}
	
	@RequestMapping({"/list", "/"})
	public String getArticleList(Model model) {
		articleList = boardService.listArticles();
		model.addAttribute("dataList", articleList);
		return "list";
	}
	
	@RequestMapping("/add")
	public String writeArticle() {
		return "write";
	}
	
	@PostMapping(value="/addarticle")
	public String addArticle(@RequestParam(value="i_title") String title, 
			@RequestParam(value="i_content") String content) {
		noticeBoard.setTitle(title);
		noticeBoard.setContent(content);
		noticeBoard.setWrite_id("D");
		
		boardService.addArticle(noticeBoard);
		
		return "redirect:list";
		
	}
	
	@GetMapping("/view")
	public ModelAndView viewArticle(@RequestParam(value="no") String articleNO) {
		noticeBoard = boardService.viewArticle(Integer.parseInt(articleNO));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("article", noticeBoard);
		return mv;
	}
	
	@PostMapping("/edit")
	public String editArticle(@RequestParam(value="articleNo") String articleNo
			, @RequestParam(value="title") String title
			, @RequestParam(value="content") String content
			, RedirectAttributes redirectAtt) {
		noticeBoard.setArticle_no(Integer.parseInt(articleNo));
		noticeBoard.setTitle(title);
		noticeBoard.setContent(content);
		boardService.editArticle(noticeBoard);
		redirectAtt.addAttribute("no" , articleNo);
		return "redirect:view";
	}
	
	@PostMapping("/remove")
	public String removeArticle(@RequestParam(value="articleNo") String articleNo) {
		boardService.removeArticle(Integer.parseInt(articleNo));
		return "redirect:list";
	}
	
}

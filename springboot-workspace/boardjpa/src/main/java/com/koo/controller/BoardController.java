package com.koo.controller;

import com.koo.model.NoticeBoard;
import com.koo.service.BoardService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller("boardController")
@RequestMapping("/notice")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;

	private List<NoticeBoard> articleList;

	Logger logger = LoggerFactory.getLogger("wnsud9771.controller.BoardController");

	@RequestMapping({ "/list", "/" })
	public String getArticleList(Model model) {
		articleList = boardService.listArticles();
		model.addAttribute("dataList", articleList);
		return "list";
	}

	@RequestMapping("/add")
	public String writeArticle() {

		logger.info("글쓰기 실행");
		return "write";
	}

	@PostMapping(value = "/addarticle")
	public String addArticle(@RequestParam(value = "i_title") String title,
			@RequestParam(value = "i_content") String content) {
		NoticeBoard noticeBoard = new NoticeBoard();
		noticeBoard.setTitle(title);
		noticeBoard.setContent(content);
		noticeBoard.setWrite_id("bit");

		boardService.addArticle(noticeBoard);

		logger.info("게시글 추가: " + title);

		return "redirect:list";
	}

	@GetMapping("/view")
	public ModelAndView viewArticle(@RequestParam(value = "no") Integer articleNo) {
		NoticeBoard noticeBoard = boardService.viewArticle(articleNo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("view");
		mv.addObject("article", noticeBoard);

		logger.info("상세조회: " + articleNo);
		return mv;
	}

	@PostMapping(value = "/edit")
	public String editArticle(@RequestParam Integer article_No, @RequestParam String title, @RequestParam String content,RedirectAttributes redirectAtt) {
		NoticeBoard noticeBoard = new NoticeBoard();
		noticeBoard.setId(article_No);
		noticeBoard.setTitle(title);
		noticeBoard.setContent(content);

		boardService.editArticle(noticeBoard);
		redirectAtt.addAttribute("no", article_No);
		logger.info("게시글삭제: " + article_No);
		return "redirect:view";
	}

	@PostMapping(value = "/remove")
	public String removeArticle(@RequestParam Integer articleNo) {
		boardService.deleteArticle(articleNo);
		return "redirect:list";
	}
}


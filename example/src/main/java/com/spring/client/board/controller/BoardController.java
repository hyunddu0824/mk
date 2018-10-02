package com.spring.client.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	Logger logger = Logger.getLogger(BoardController.class);
	
	@Autowired		//�쓽議댁꽦 二쇱엯
	private BoardService boardService;
	
	@RequestMapping(value="/boardList.do", method=RequestMethod.GET)
	public String boardList(BoardVO bvo, Model model) {
		
		List<BoardVO> boardList = boardService.boardList(bvo);
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
		
	}
	
	//글쓰기 폼
	@RequestMapping(value="writeForm.do")
	public String writeForm() {
		logger.info("writeForm 호출 성공");
		
		return "board/writeForm";
	}
	
	//글쓰기 구현하기
	
	public String boardInsert(BoardVO bvo, Model model,HttpServletRequest request) {
		logger.info("boardInsert 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = boardService.boardInsert(bvo);
		
		if(result == 1 ) {
			url = "/board/boardList.do";
		}else {
			model.addAttribute("code", 1);
			url = "board/writeForm.do";
		}
		return "redirect:"+url;
		
	}
	
	//글 상세 보기
	@RequestMapping(value = "boardDetail.do", method=RequestMethod.GET)
	public String boardDetail(BoardVO bvo, Model model) {
		logger.info("boardDetail 호출 성공");
		logger.info("b_no =" + bvo.getB_no());
		
		BoardVO detail = new BoardVO();
		detail = boardService.boardDetail(bvo);
		
		model.addAttribute("detail", detail);
		return "board/boardDetail";
	}
	
	/*public String boardInsert(BoardVO bvo, Model model, HttpServletRequest request)*/
	
}

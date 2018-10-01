package com.spring.client.board.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.client.board.service.BoardService;
import com.spring.client.board.vo.BoardVO;

@Controller
public class BoardController {

	Logger logger = Logger.getLogger(BoardController.class);
	
	@Autowired		//의존성 주입
	private BoardService boardService;
	
	//리스트 보기
	@RequestMapping(value="/boardList.do", method=RequestMethod.GET)
	public String boardList(BoardVO bvo, Model model) {
		
		List<BoardVO> boardList = boardService.boardList(bvo);
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
		
	}
}

package com.spring.client.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.board.dao.BoardDao;
import com.spring.client.board.vo.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {

	Logger logger = Logger.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> boardList(BoardVO bvo) {
		List<BoardVO> myList = null;
		myList = boardDao.boardList(bvo);
		return myList;
	}

	@Override
	public List<BoardVO> boardDetail2(BoardVO bvo) {
		// TODO Auto-generated method stub
		List<BoardVO> myList = boardDao.boardDetail2(bvo);
		return null;
	}

}

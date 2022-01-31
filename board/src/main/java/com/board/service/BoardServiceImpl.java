package com.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

//	전체 목록 조회
	@Override
	public List<BoardVO> list() throws Exception {
		return dao.list();
	}

//	작성
	@Override
	public void write(BoardVO vo) throws Exception {
		dao.write(vo);
	}

//	상세 조회
	@Override
	public BoardVO view(int bno) throws Exception {
		return dao.view(bno);
	}
	
//	수정
	@Override
	public void modify(BoardVO vo) throws Exception {
	  
	 dao.modify(vo);
	}
	
	

}

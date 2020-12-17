package com.jun.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.board.dao.BoardDAO;
import com.jun.board.domain.BoardVO;
import com.jun.member.domain.MemberVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO dao;
	
	@Override
	public void deleteBoardAll(MemberVO vo) {
		dao.deleteBoardAll(vo);
	}

	@Override
	public int cntBoard() {
		return dao.cntBoard();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
	}

	@Override
	public void deleteBoardOne(BoardVO vo) {
		dao.deleteBoardOne(vo);
	}

	@Override
	public BoardVO selectBoardOne(BoardVO vo) {
		return dao.selectBoardOne(vo);
	}

	@Override
	public List<BoardVO> selectBoardAll(BoardVO vo) {
		return dao.selectBoardAll(vo);
	}

	@Override
	public int cntKeyword(BoardVO vo) {
		return dao.cntKeyword(vo);
	}
	
	
	@Override
	public void updateBoardOne(BoardVO vo) {
		dao.updateBoardOne(vo);
	}

	@Override
	public void updateCnt(BoardVO vo) {
		dao.updateCnt(vo);
	}

	@Override
	public List<BoardVO> keywordSearch(BoardVO vo) {
		return dao.keywordSearch(vo);
	}

	@Override
	public int cntMemBoard(BoardVO vo) {
		return dao.cntMemBoard(vo);
	}

	@Override
	public List<BoardVO> selectAdminBoard() {
		return dao.selectAdminBoard();
	}

	

}

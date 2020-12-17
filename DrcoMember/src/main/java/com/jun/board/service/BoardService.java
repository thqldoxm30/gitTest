package com.jun.board.service;

import java.util.List;

import com.jun.board.domain.BoardVO;
import com.jun.member.domain.MemberVO;

public interface BoardService {
	
	List<BoardVO> selectAdminBoard();
	void deleteBoardAll(MemberVO vo); //모든 게시물 삭제
	
	
//	사용자 전용 메소드
	//insert
	void insertBoard(BoardVO vo); //게시물 등록
	
	//delete
	void deleteBoardOne(BoardVO vo); //내가 쓴 해당 게시물 삭제
	
	//select
	BoardVO selectBoardOne(BoardVO vo); //내가 쓴 게시물 조회
	List<BoardVO> selectBoardAll(BoardVO vo); //게시물 전체 조회
	List<BoardVO> keywordSearch(BoardVO vo); //키워드 검색
	int cntBoard(); //전체 게시물 수
	int cntKeyword(BoardVO vo);
	int cntMemBoard(BoardVO vo);
	
	//update
	void updateBoardOne(BoardVO vo); //게시물 수정
	void updateCnt(BoardVO vo); //조회수 수정
}

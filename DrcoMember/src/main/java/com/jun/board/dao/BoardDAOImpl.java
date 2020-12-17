package com.jun.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jun.board.domain.BoardVO;
import com.jun.member.domain.MemberVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
//	insert
	@Override
	public void insertBoard(BoardVO vo) {
		sqlSession.insert("boardNS.insertBoard", vo);
	}

//	delete
	@Override
	public void deleteBoardOne(BoardVO vo) {
		sqlSession.delete("boardNS.deleteBoardOne", vo);
	}

	@Override
	public void deleteBoardAll(MemberVO vo) {
		sqlSession.delete("boardNS.deleteBoardAll", vo);
	}
	
//	select
	@Override
	public BoardVO selectBoardOne(BoardVO vo) {
		return sqlSession.selectOne("boardNS.selectBoardOne", vo);
	}

	@Override
	public List<BoardVO> selectBoardAll(BoardVO vo) {
		return sqlSession.selectList("boardNS.selectBoardAll", vo);
	}
	
	@Override
	public List<BoardVO> keywordSearch(BoardVO vo) {
		return sqlSession.selectList("boardNS.keywordSearch", vo);
	}

	@Override
	public int cntBoard() {
		return sqlSession.selectOne("boardNS.cntBoard");
	}
	
	@Override
	public int cntKeyword(BoardVO vo) {
		return sqlSession.selectOne("boardNS.cntKeyword", vo);
	}
	
	@Override
	public int cntMemBoard(BoardVO vo) {
		return sqlSession.selectOne("boardNS.cntMemBoard", vo);
	}
	
//	update
	@Override
	public void updateBoardOne(BoardVO vo) {
		sqlSession.update("boardNS.updateBoardOne", vo);
		
	}
	
	@Override
	public void updateCnt(BoardVO vo) {
		sqlSession.update("boardNS.updateCnt", vo);
	}

	@Override
	public List<BoardVO> selectAdminBoard() {
		return sqlSession.selectList("boardNS.selectAdminBoard");
	}


}

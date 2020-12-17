package com.jun.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jun.board.domain.BoardVO;
import com.jun.member.domain.MemberVO;

@Repository("MemberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
//	insert
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("memberNS.insertMember", vo);
	}
	
//	delete
	@Override
	public void deleteMemberAll() {
		sqlSession.delete("memberNS.deleteMemberAll");
	}

	@Override
	public void deleteMemberOne(String id) {
		sqlSession.delete("memberNS.deleteMemberOne", id);
		
	}
	
//	select
	@Override
	public MemberVO selectMemberOne(String id) {
		return sqlSession.selectOne("memberNS.selectMemberOne", id);
	}
	
	@Override
	public List<MemberVO> selectMemberAll() {
		return sqlSession.selectList("memberNS.selectMemberAll");
	}

	@Override
	public int cntMember() {
		return sqlSession.selectOne("memberNS.cntMember");
	}

	@Override
	public List<MemberVO> selectMemberGender(MemberVO vo) {
		return sqlSession.selectList("memberNS.selectMemberGender", vo);
	}

	@Override
	public void updateMyInfo(MemberVO vo) {
		sqlSession.update("memberNS.updateMyInfo", vo);
	}

	@Override
	public void updateMemInfo(MemberVO vo) {
		sqlSession.update("memberNS.updateMemInfo", vo);
	}

	@Override
	public List<MemberVO> selectMemberYear(int startYear, int endYear) {
		HashMap<String, Integer> year = new HashMap<String, Integer>();
		year.put("startYear", startYear);
		year.put("endYear", endYear);		
		
		return sqlSession.selectList("memberNS.selectMemberYear", year);
	}

	@Override
	public void updateBoardCnt(MemberVO vo) {
		sqlSession.update("memberNS.updateBoardCnt", vo);
	}

	@Override
	public void updateState(MemberVO vo) {
		sqlSession.update("memberNS.updateState", vo);
	}

}

package com.jun.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.member.dao.MemberDAO;
import com.jun.member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;
	
	
	@Override
	public void updateMemInfo(MemberVO vo) {
		dao.updateMemInfo(vo);
	}

	@Override
	public void deleteMemberAll() {
		dao.deleteMemberAll();
	}

	@Override
	public List<MemberVO> selectMemberAll() {
		return dao.selectMemberAll();
	}

	@Override
	public List<MemberVO> selectMemberGender(MemberVO vo) {
		return dao.selectMemberGender(vo);
	}

	@Override
	public List<MemberVO> selectMemberYear(int startYear, int endYear) {
		return dao.selectMemberYear(startYear, endYear);
	}

	@Override
	public int cntMember() {
		return dao.cntMember();
	}

	@Override
	public void insertMember(MemberVO vo) {
		dao.insertMember(vo);
	}

	@Override
	public void deleteMemberOne(String id) {
		dao.deleteMemberOne(id);
	}

	@Override
	public MemberVO selectMemberOne(String id) {
		return dao.selectMemberOne(id);
	}

	@Override
	public void updateMyInfo(MemberVO vo) {
		dao.updateMyInfo(vo);
	}

	@Override
	public void updateBoardCnt(MemberVO vo) {
		dao.updateBoardCnt(vo);
	}

	@Override
	public void updateState(MemberVO vo) {
		dao.updateState(vo);
	}
	
}

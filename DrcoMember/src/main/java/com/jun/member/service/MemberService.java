package com.jun.member.service;

import java.util.List;

import com.jun.member.domain.MemberVO;

public interface MemberService {
//	관리자 전용
	//update
	void updateMemInfo(MemberVO vo); //회원 정보 수정
	
	//delete
	void deleteMemberAll(); //회원 전체 삭제
	
	//select
	List<MemberVO> selectMemberAll(); //모든 사용자 조회	
	List<MemberVO> selectMemberGender(MemberVO vo); //모든 사용자 조회	
	List<MemberVO> selectMemberYear(int startYear, int endYear); //연도별 사용자 조회
	int cntMember(); //모든 사용자 수 조회
	
//	사용자 전용
	//insert
	void insertMember(MemberVO vo); //회원 가입
	
	//delete
	void deleteMemberOne(String id); //회원 탈퇴
	
	//select
	MemberVO selectMemberOne(String id); //내 정보 조회
	
	//update
	void updateMyInfo(MemberVO vo); //내 정보 수정
	void updateBoardCnt(MemberVO vo);
	void updateState(MemberVO vo);
}

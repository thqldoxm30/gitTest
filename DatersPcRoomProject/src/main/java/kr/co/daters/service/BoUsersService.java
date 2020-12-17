package kr.co.daters.service;

import java.util.List;

import kr.co.daters.domain.BoUsersVO;

public interface BoUsersService {
	BoUsersVO selectOneUser(String id);
	List<BoUsersVO> selectUserAll(int boCode);
	void insertUser(BoUsersVO vo);
	void useTime(BoUsersVO vo);
	void insertTime(BoUsersVO vo);
	void updateUser(BoUsersVO vo);
	void updateSeatUser(BoUsersVO vo);
	List<BoUsersVO> usingSeat(int boCode);
}

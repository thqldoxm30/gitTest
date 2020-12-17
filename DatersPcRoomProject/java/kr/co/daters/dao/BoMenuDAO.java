package kr.co.daters.dao;

import java.util.List;

import kr.co.daters.domain.BoMenuVO;

public interface BoMenuDAO {
	List<BoMenuVO> selectMenu(int boCode);
	List<BoMenuVO> choiceMenuInfo(int mNo);
	void updateQuantity(int mNo);
}

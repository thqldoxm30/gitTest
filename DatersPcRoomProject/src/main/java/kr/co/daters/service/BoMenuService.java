package kr.co.daters.service;

import java.util.List;

import kr.co.daters.domain.BoMenuVO;

public interface BoMenuService {
	List<BoMenuVO> selectMenu(int boCode);
	List<BoMenuVO> choiceMenuInfo(int mNo);
	void updateQuantity(int mNo);
}

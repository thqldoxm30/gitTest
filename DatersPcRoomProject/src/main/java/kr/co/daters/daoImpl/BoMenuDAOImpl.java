package kr.co.daters.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.BoMenuDAO;
import kr.co.daters.domain.BoMenuVO;

@Repository
public class BoMenuDAOImpl implements BoMenuDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoMenuVO> selectMenu(int boCode) {
		return sqlSession.selectList("boMenuNS.selectMenu", boCode);
	}

	@Override
	public List<BoMenuVO> choiceMenuInfo(int mNo) {
		return sqlSession.selectList("boMenuNS.choiceMenuInfo", mNo);
	}

	@Override
	public void updateQuantity(int mNo) {
		sqlSession.update("boMenuNS.updateQuantity", mNo);
		
	}

}

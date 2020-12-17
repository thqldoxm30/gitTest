package kr.co.daters.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.UHistoryDAO;
import kr.co.daters.domain.UHistoryVO;

@Repository
public class UHistoryDAOImpl implements UHistoryDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void usersHistory(UHistoryVO vo) {
		sqlSession.insert("uHistoryNS.usersHistory", vo);
	}

	@Override
	public List<UHistoryVO> usersHistorySelectAll(int boCode) {
		return sqlSession.selectList("uHistoryNS.usersHistorySelectAll", boCode);
	}
}

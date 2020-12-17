package kr.co.daters.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.daters.dao.BoHistoryDAO;
import kr.co.daters.domain.BoHistoryVO;

@Repository
public class BoHistoryDAOImpl implements BoHistoryDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public void insertBoHistory(BoHistoryVO vo) {
		sqlSession.insert("boHistoryNS.insertBoHistory",vo);
	}

	@Override
	public List<BoHistoryVO> selectBoHistoryList(int boCode) {
		return sqlSession.selectList("boHistoryNS.selectBoHistoryList", boCode);
	}
	
}

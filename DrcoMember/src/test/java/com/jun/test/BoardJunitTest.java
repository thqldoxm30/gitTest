package com.jun.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jun.board.dao.BoardDAO;
import com.jun.board.domain.BoardVO;
import com.jun.member.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:root-context.xml")
public class BoardJunitTest {
	@Autowired
	BoardDAO dao;
	
	BoardVO vo1, vo2;
	
	@Before
	public void setting() {
//		vo1 = new BoardVO("준1", "타이틀1", "콘텐트1");
//		vo2 = new BoardVO("한나2", "타이틀2", "콘텐트2");
	}
	
//	deleteAll test
	@Test
	public void test1() {
		assertEquals(dao.cntBoard(), 0);
	}
	
//	insert/select test
	@Test
	public void test2() {
		
		dao.insertBoard(vo1);
//		dao.insertBoard(vo2);
//		assertEquals(dao.cntBoard(), 2);
//		BoardVO result = dao.selectBoardOne(vo1.getDc_id());
//		BoardVO result2 = dao.selectBoardOne(vo2.getDc_id());
//		assertEquals(result.getDc_id(), vo1.getDc_id());
//		assertEquals(result2.getDc_id(), vo2.getDc_id());
//		assertEquals(dao.selectBoardAll().size(), 2);
	}
	
//	deleteOne test
	@Test
	public void test3() {
//		dao.deleteBoardOne(vo1.getDc_id());
		assertEquals(dao.cntBoard(), 1);
	}
	
}

package com.jun.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jun.member.dao.MemberDAO;
import com.jun.member.domain.MemberVO;


@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.DEFAULT)
@ContextConfiguration(locations = "classpath:root-context.xml")
public class MemberJunitTest {
	
	@Autowired
	MemberDAO dao;
	
	MemberVO vo1, vo2;
	
	
	@Before
	public void Before() throws Exception{
		vo1 = new MemberVO("준1", "준1", "준1", 950614, "male", "주소1", "메일1");
		vo2 = new MemberVO("한나2", "한나2", "한나2", 950716, "female", "주소2", "메일2");
	}
	
//	deleteAll test
	@Test
	public void test1() {
		dao.deleteMemberAll();
		assertEquals(dao.cntMember(), 0);
	}
	
//	insert/select test
	@Test
	public void test2() {
		
		dao.insertMember(vo1);
		dao.insertMember(vo2);
		assertEquals(dao.cntMember(), 2);
		MemberVO result = dao.selectMemberOne(vo1.getDc_id());
		MemberVO result2 = dao.selectMemberOne(vo2.getDc_id());
		assertEquals(vo1.getDc_password(), result.getDc_password());
		assertEquals(vo2.getDc_name(), result2.getDc_name());
//		assertEquals(dao.selectMemberAll().size(), 2);
	}
	
//	deleteOne test
	@Test
	public void test3() {
		dao.deleteMemberOne(vo1.getDc_id());
		assertEquals(dao.cntMember(), 1);
	}
	
//	insert test2
	@Test
	public void test4() {
		dao.insertMember(vo1);
	}
	
	

	
}

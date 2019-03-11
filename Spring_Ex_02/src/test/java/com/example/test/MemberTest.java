package com.example.test;


import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.MemberDAO;
import com.example.dto.MemberVO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/root-context.xml"})
//@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberTest {
	
	@Autowired
	private MemberDAO dao;
	private DataSource ds;	
	
	
	private static Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	@Test @Ignore
	public void testListPage() throws Exception {

		int page = 1;
		logger.info("testing for listPage...");
		List<MemberVO> list = dao.selectMember();

		for (MemberVO memberVO : list) {
			logger.info(memberVO.getId() + ":" + memberVO.getName() + ":" + memberVO.getPw());
		}
	}
	@Test
	public void testRead() throws Exception {

		
		logger.info("testing for Read...");
		List<MemberVO> read = dao.read("id1");

		for (MemberVO memberVO : read) {
			logger.info(memberVO.getId() + ":" + memberVO.getName() + ":" + memberVO.getPw());
		}
	}
	@Test  @Ignore
	public void testConection()throws Exception{
		
		try(Connection con = ds.getConnection()){
			
			System.out.println(con);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
	
	

}

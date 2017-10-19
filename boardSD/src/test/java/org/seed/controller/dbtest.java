package org.seed.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.board.domain.BoardVO;
import org.board.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class dbtest {
	private static final Logger logger = Logger.getLogger(dbtest.class);

	
	@Inject
	SqlSession sess;
	
	@Inject
	BoardDAO dao;
		

	
	@Test
	public void daoInsertTest(){
		
		BoardVO vo = new BoardVO();
		
		for (int i = 0; i <105; i++) {
			
			vo.setBoard_title("title"+i);
			vo.setBoard_content("content"+i);
			vo.setBoard_writer("writer"+i);
			
		
			dao.create(vo);
			
		}
		
		
		
		}
	
	@Test
	public void serchTest(){
		
		String key = "4";
		
			dao.listSearch(key);
		
		}
	
	@Test
	public void serchTotalTest(){
		
		String key = "4";
			
			dao.totalSearch(key);
		
		}
	
	
}
		
	
		
	
	
	
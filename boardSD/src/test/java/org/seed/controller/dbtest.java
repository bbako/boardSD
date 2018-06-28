package org.seed.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.board.aop.SampleAOP;
import org.board.domain.BoardVO;
import org.board.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class dbtest {
	private static final Logger logger = LoggerFactory.getLogger(SampleAOP.class);


	
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
	public void serchTotalTest(){
		
		String key = "4";
			
			dao.totalSearch(key);
		
		}
	
	
}
		
	
		
	
	
	
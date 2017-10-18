package org.seed.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.board.domain.BoardVO;
import org.board.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
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
		
		vo.setBoard_title("title122_s_dao");
		vo.setBoard_content("bOARD_CONTENT122_s_dao");
		vo.setBoard_writer("bOARD_WRITER22_s_dao");
		
		System.out.println(vo.toString());
	
		dao.create(vo);
		
		}
	
	
}
		
	
		
	
	
	
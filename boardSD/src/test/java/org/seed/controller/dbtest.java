package org.seed.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.board.domain.BoardVO;
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
	SqlSessionTemplate sess;
		
	@Test
	public void qInsertTest(){
		
		BoardVO vo = new BoardVO();
		
		vo.setBOARD_TITLE("title122");
		vo.setBOARD_CONTENT("bOARD_CONTENT122");
		vo.setBOARD_WRITER("bOARD_WRITER22");
	
		sess.insert("org.board.persistence.BoardDAO.create",vo);
		}
	
	
}
		
	
		
	
	
	
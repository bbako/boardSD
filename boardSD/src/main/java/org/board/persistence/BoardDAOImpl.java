package org.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.board.domain.BoardVO;
import org.board.domain.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	SqlSession sess;
	
	String namespace = "org.board.persistence.BoardDAO";
	
	@Override
	public void create(BoardVO vo) {
			sess.insert(namespace+".create", vo);
	}


	@Override
	public List<BoardVO> listAll(int page) {
		
		
		return sess.selectList(namespace + ".listAll", page);
	}


	@Override
	public int total() {
		
		return sess.selectOne(namespace+".total");
		
	}

}

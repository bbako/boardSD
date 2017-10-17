package org.board.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.board.domain.BoardVO;
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

}

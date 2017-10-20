package org.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


	@Override
	public List<BoardVO> listAll(int page) {
		
		
		return sess.selectList(namespace + ".listAll", page);
	}


	@Override
	public int total() {
		
		return sess.selectOne(namespace+".total");
		
	}


	@Override
	public List<BoardVO> listSearch(String key, int page) {
		
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("key", key);
		 map.put("page", page);
		return sess.selectList(namespace+".listSearch", map);
	}


	@Override
	public int totalSearch(String key) {
		return sess.selectOne(namespace+".totalSearch", key);
	}

}

package org.board.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.board.domain.UserVO;
import org.board.dto.LoginDTO;
import org.springframework.stereotype.Repository;
@Repository
public class LoginDAOImpl implements LoginDAO {
	
	String namespace=  "org.board.persistence.LoginDAO";

	@Inject
	SqlSession sess;

	@Override
	public UserVO tryLogin(LoginDTO dto) {
		return sess.selectOne(namespace+".tryLogin", dto);
	}
	
	

}

package org.board.service;

import javax.inject.Inject;

import org.board.domain.UserVO;
import org.board.dto.LoginDTO;
import org.board.persistence.LoginDAO;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	LoginDAO dao;
	
	@Override
	public UserVO tryLogin(LoginDTO dto) {
		return dao.tryLogin(dto);
	}

	@Override
	public void regist(UserVO vo) {
		dao.regist(vo);
	}

}

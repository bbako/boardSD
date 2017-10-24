package org.board.service;

import javax.inject.Inject;

import org.board.domain.BoardVO;
import org.board.domain.FoolException;
import org.board.domain.UserVO;
import org.board.dto.LoginDTO;
import org.board.persistence.BoardDAO;
import org.board.persistence.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	LoginDAO dao;
	
	@Autowired
	BoardDAO bdao;
	
	@Override
	public UserVO tryLogin(LoginDTO dto) {
		return dao.tryLogin(dto);
	}

	@Override
	@Transactional
	public void regist(UserVO vo, BoardVO bvo) {
		dao.regist(vo);
		
		if (bvo.getBoard_title().equals("1")) {
			throw new FoolException();	
		}
		bdao.create(bvo);
	}

}

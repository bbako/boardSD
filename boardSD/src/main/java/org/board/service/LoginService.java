package org.board.service;

import org.board.domain.UserVO;
import org.board.dto.LoginDTO;

public interface LoginService {
	
	public UserVO tryLogin(LoginDTO dto);
	
	public void regist(UserVO vo);

	

}

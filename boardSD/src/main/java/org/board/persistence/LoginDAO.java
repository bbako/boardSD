package org.board.persistence;

import org.board.domain.UserVO;
import org.board.dto.LoginDTO;

public interface LoginDAO {
	
	public UserVO tryLogin(LoginDTO dto);

}

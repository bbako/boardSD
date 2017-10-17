package org.board.service;

import javax.inject.Inject;

import org.board.domain.BoardVO;
import org.board.persistence.BoardDAO;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public void create(BoardVO VO) {
			dao.create(VO);
	}

}

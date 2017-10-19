package org.board.service;

import java.util.List;

import javax.inject.Inject;

import org.board.domain.BoardVO;
import org.board.persistence.BoardDAO;
import org.springframework.stereotype.Service;


@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDAO dao;
	
	@Override
	public void create(BoardVO VO) {
			dao.create(VO);
	}

	@Override
	public int total() {
		return dao.total();	
	}

	@Override
	public List<BoardVO> listAll(int page ) {
		return dao.listAll(page);
	}

	@Override
	public List<BoardVO> listSearch(String key) {
		return dao.listSearch(key);
	}

	@Override
	public int totalSearch(String key) {
		return dao.totalSearch(key);
	}



}

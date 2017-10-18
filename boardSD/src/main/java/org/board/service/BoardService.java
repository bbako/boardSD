package org.board.service;

import java.util.List;

import org.board.domain.BoardVO;

public interface BoardService {
	
	public void create(BoardVO VO);
	public List<BoardVO> listAll() throws Exception;

}

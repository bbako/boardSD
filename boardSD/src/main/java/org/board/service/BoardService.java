package org.board.service;

import java.util.List;

import org.board.domain.BoardVO;
import org.board.domain.Criteria;

public interface BoardService {
	
	public void create(BoardVO VO);
	public List<BoardVO> listAll(int page);
	public int total();


}

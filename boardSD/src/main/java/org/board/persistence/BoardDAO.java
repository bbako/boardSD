package org.board.persistence;

import java.util.List;

import org.board.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo);
	public List<BoardVO> listAll(int page);
	public int total();
	public List<BoardVO> listSearch(String key);
	public int totalSearch(String key);

	



}

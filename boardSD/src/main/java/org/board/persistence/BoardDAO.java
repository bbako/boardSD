package org.board.persistence;

import java.util.List;

import org.board.domain.BoardVO;
import org.board.domain.Criteria;

public interface BoardDAO {
	
	public void create(BoardVO vo);
	public List<BoardVO> listAll(int page);
	public int total();


}

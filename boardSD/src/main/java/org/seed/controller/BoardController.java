package org.seed.controller;

import java.util.List;

import javax.inject.Inject;

import org.board.domain.BoardVO;
import org.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
	
	@Inject
	BoardService boardService;

	@RequestMapping("board_list.do")
	public ModelAndView board_list() throws Exception {
		List<BoardVO> list = boardService.listAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board_list");
        mv.addObject("list", list);
        return mv; 
	}
	
}

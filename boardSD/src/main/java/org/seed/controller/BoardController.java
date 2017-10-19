package org.seed.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.board.domain.BoardVO;
import org.board.domain.Criteria;
import org.board.domain.PageMaker;
import org.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BoardController {
	
	private static final Logger logger = Logger.getLogger(BoardController.class);

	
	@Inject
	BoardService boardService;

	/*@RequestMapping("board_list.do")
	public ModelAndView board_list(Criteria cri) throws Exception {
		
		System.out.println("main get");
		
		System.out.println(cri);
							
		List<BoardVO> list = boardService.listAll(1);
		
		System.out.println(list.toString());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board_list");
        mv.addObject("list", list);
		int total=boardService.total();
		mv.addObject("pageMaker", new PageMaker(cri, total));

        return mv; 
	}*/
	
	@GetMapping("/list")
	public ModelAndView listGet(Criteria cri){
		
		System.out.println("main get");
		
		System.out.println(cri);
							
		List<BoardVO> list = boardService.listAll(1);
		
		System.out.println(list.toString());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board_list");
        mv.addObject("list", list);
		int total=boardService.total();
		mv.addObject("pageMaker", new PageMaker(cri, total));

        return mv; 
		
	}
	
	@PostMapping("/list")
	public @ResponseBody List<BoardVO> listpost(@RequestParam("page") Integer page){
		
		logger.info("리스크 보내기");
		
		logger.info(page);
		
		int start = (page-1)*10;
		
		List<BoardVO> list= boardService.listAll(start);
		
		return list;
		
	}
	
}

package org.seed.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.board.domain.BoardVO;
import org.board.domain.Criteria;
import org.board.domain.PageMaker;
import org.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
	public void listPost() {
		
		
	}
		
	/*@PostMapping("/list")
	public ResponseEntity<Map<String, Object>> listget(@RequestParam("page") int page){
		
		logger.info("list get");
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		Criteria cri = new Criteria();
		
		 page = 1;
		
		cri.setPage(1);
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardVO> list = boardService.listAll(1);
		
		map.put("list", list);
		
		int total = boardService.total();
		
		logger.info(total);
		
		pageMaker.setTotal(total);
		
		map.put("pageMaker", pageMaker);
		
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
		
		
		
	}*/

		
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> sendadlist(@RequestParam("page") Integer page){

		logger.info("zzzzzzzzzzzzzzzdddd");
		logger.info(""+page);
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		Criteria cri = new Criteria();
		
		cri.setPage(page);
		
		int total = boardService.total();
		
		PageMaker pageMaker = new PageMaker(cri, total);
		
		pageMaker.setCri(cri);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BoardVO> list = boardService.listAll((page-1)*10);
		
		map.put("list", list);
		
		map.put("pageMaker", pageMaker);
		
		entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return entity;
		
		}
		
				 
		
		
	}
		
	


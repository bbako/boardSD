package org.seed.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.board.domain.BoardVO;
import org.board.domain.Criteria;
import org.board.domain.PageMaker;
import org.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/list")
	public void listGet(HttpSession session, Model model) {
		
		Object vo = session.getAttribute("login");
		
		model.addAttribute("login", vo );
		
	}

		
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> sendadlist(@RequestParam("page") Integer page, @RequestParam("key") String key){

		logger.info("zzzzzzzzzzzzzzzdddd");
		logger.info("page"+page);
		logger.info("key:"+key);
		
		ResponseEntity<Map<String, Object>> entity = null;
		
		Criteria cri = new Criteria();
		
		cri.setPage(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(key == "") {
		
			int total = boardService.total();
			
			PageMaker pageMaker = new PageMaker(cri, total);
			
			pageMaker.setCri(cri);
			
			List<BoardVO> list = boardService.listAll((page-1)*10);
			
			map.put("list", list);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
			return entity;
			
		}else {
			
			int total = boardService.totalSearch(key);
			
			PageMaker pageMaker = new PageMaker(cri, total);
			
			pageMaker.setCri(cri);
			
			List<BoardVO> list = boardService.listSearch(key, (page-1)*10);
			
			map.put("list", list);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
			return entity;
			
		}
	}
	
	@PostMapping("/search")
	@ResponseBody
	public List<BoardVO> search(@RequestParam("keyWord") String keyWord) {
		
		logger.info(keyWord);
		
		List<BoardVO> search = boardService.serachAuto(keyWord);
		
		return search;
	}
	
	@GetMapping("/showOne")
	public Model showOnePost(@RequestParam("oneTitleShow") String seq_id, Model model) {
		
		logger.info("show one ");
		
		BoardVO oneVO = boardService.showOne(seq_id);
		
		model.addAttribute("OneVO", oneVO);
		
		return model;
		
	}

		
}
		
	


package org.seed.controller;

import javax.inject.Inject;

import org.board.domain.BoardVO;
import org.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/new")
public class NewController {
	
	@Inject
	BoardService ser;
	
	@GetMapping
	public void newGet() {
		System.out.println("new get");
		
		
	}
	
	@PostMapping	 
	public void newPost(@RequestParam String board_title, @RequestParam String board_content, @RequestParam String board_writer) {
		System.out.println("new post");
		
		BoardVO vo = new BoardVO();
				
		vo.setBoard_title(board_title);
		vo.setBoard_content(board_content);
		vo.setBoard_writer(board_writer);
		
		ser.create(vo);
		
	}

}

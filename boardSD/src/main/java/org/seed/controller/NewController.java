package org.seed.controller;

import org.board.domain.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/new")
public class NewController {
	
	@GetMapping
	public void newGet() {
		System.out.println("new get");
		
		
	}
	
	@PostMapping
	public void newPost(@RequestBody BoardVO vo) {
		System.out.println("new post");
		
		System.out.println(vo.toString());
		
		
	}

}

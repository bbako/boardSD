package org.seed.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.board.domain.UserVO;
import org.board.dto.LoginDTO;
import org.board.service.BoardService;
import org.board.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Inject
	BoardService ser;
	
	@Inject
	LoginService lser;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public void newGet(@ModelAttribute("dto") LoginDTO dto) {
		
		
	}
	
	@RequestMapping(value="/loginPost", method = RequestMethod.POST) 
	public void LoginPost(LoginDTO dto, HttpSession session, Model model) {
		
		UserVO vo =  lser.tryLogin(dto);
		
		if(vo ==null) {
			
			return;
			
		}
		
		model.addAttribute("userVO",vo);
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("login");
		
		return "redirect:/list";
	}
	
	@GetMapping("/signup")
	public void signupGet() {
		
		
	}
	
	@PostMapping("/signup")
	public String signupPost(HttpSession session, UserVO userVO) {
		
		logger.info(userVO);
		
		lser.regist(userVO);
		
		session.setAttribute("login", userVO);
		
		return "redirect:/list";
	} 

}

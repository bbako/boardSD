package org.board.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.board.aop.SampleAOP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleAOP.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("interceptor post @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		HttpSession session = request.getSession();
		Object userVO = modelAndView.getModelMap().get("userVO");
		
		if (userVO != null) {
			logger.info("new login success");
			session.setAttribute("login", userVO);
			response.sendRedirect("/list");
			
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("interceptor pre @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null) {
			
			logger.info("clear");
			
			session.removeAttribute("login");
			
		}
		
		return true;
	}
	
}

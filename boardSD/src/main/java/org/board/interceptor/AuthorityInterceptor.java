package org.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.board.aop.SampleAOP;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthorityInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleAOP.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("authority pre @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			
			response.sendRedirect("/user/login");
		}
			
		return true;
		
	}
	
}

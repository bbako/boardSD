package org.board.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAOP {
	
	private static final Logger logger = Logger.getLogger(SampleAOP.class);


	@Before("execution(* org.board.service.LoginService*.*(..))")
    public void logBeforeAllMethods() { 
		
		logger.info("~!@~!@~!@~!@~!@~!@~!@~!@~!@~!@~!@~!@");
		
	}
	
}

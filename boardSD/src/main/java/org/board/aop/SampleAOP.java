package org.board.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAOP {
	
	private static final Logger logger = Logger.getLogger(SampleAOP.class);

	@Before("execution(* org.board.service.LoginService*.*(..))")
    public void logBeforeAllMethods() { 
		
		logger.info("===================================");
	}
	
	@Before("execution(* org.board.service.BoardService*.*(..))")
    public void logservice(JoinPoint jp) { 
		
		logger.info("******************************************************************************************");
		logger.info("******************************************************************************************");
		
		logger.info(Arrays.toString(jp.getArgs()));
		
		logger.info("******************************************************************************************");
		logger.info("******************************************************************************************");
		
	}
	
	@After("execution(* org.board.service.BoardService*.*(..))")
	public void logAfter() {
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	 @Around("execution(* org.board.service.BoardService*.*(..))")
	    public Object callDurationAdvice(ProceedingJoinPoint pjp) throws Throwable {
	        Signature signature = pjp.getSignature();
	        Object[] args = pjp.getArgs();
	        String argList = Arrays.toString(args);
	        System.out.println(signature.getDeclaringTypeName() +
	                "." + signature.getName() + "(" + argList + ") started");
	        long s = System.nanoTime();
	        Object proceed = pjp.proceed(args);
	        long e = System.nanoTime();
			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	        logger.info("execution time");
	        System.out.println(signature.getDeclaringTypeName() +
	                "." + signature.getName() + "(" + argList + ") ended after " +
	                ((double)(e-s)/1000000) + " ms");
	        return proceed;
	    }
	
	
}

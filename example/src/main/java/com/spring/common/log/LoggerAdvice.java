package com.spring.common.log;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Component
@Aspect
public class LoggerAdvice {

	private static final Logger logger =  LoggerFactory.getLogger(LoggerAdvice.class);
	@Before("execution(* com.spring..*Impl.*(..))")
	public void printLogging(JoinPoint jp) {
		logger.info(" ----------------------------------------- ");
		logger.info("[공통 로그 log] 비즈니스 로직 수행 전 동작 ");
		logger.info(jp.getSignature().getName());
		logger.info(Arrays.toString(jp.getArgs()));
		logger.info("----------------------------------------- ");
	}
	@Around("execution(* com.spring..*Impl.*(..))")
	public Object timeLogging (ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info(" ----------------------------------------- ");
		logger.info("[공통 로그 Log] 비즈니스 로직 수행전 동작");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		//proceed() : 실제  target 객체의 메서드를 실행하는 기능
		result = pjp.proceed();
		
		/*long endTime = System.currentTimeMillis();*/
		stopWatch.stop();
		logger.info("Class:"+ pjp.getTarget().getClass());
		logger.info(pjp.getSignature().getName() + " : 소요시간" + (stopWatch.getTotalTimeMillis()) + "ms");
		logger.info("[공통 로그 log] 비즈니스 로직 수행 후 동작 ");
		logger.info(" ----------------------------------------- ");
		return result;
		
	}

	   @AfterThrowing(pointcut="execution(* com.spring..*Impl.*(..))", throwing="exp")
	   public void exceptionLogging(JoinPoint jp, Throwable exp){
	      logger.info("-------------------------------------");
	      logger.info("[예외발생] ");
	      //logger.info("[예외발생 메서드명] "+jp.getSignature().getName());
	      //exp.printStackTrace();
	      //logger.info(exp.getMessage());
	      
	      Signature signature = jp.getSignature();
	      String methodName = signature.getName();
	      
	      String stuff = signature.toString();
	      String arguments = Arrays.toString(jp.getArgs());
	      logger.info("Write something in the log... We have caught exception in method: "
	         + methodName + " with arguments "
	         + arguments + "\nand the full toString: " 
	         + stuff + "\nthe exception is: "
	         + exp.getMessage());
	      logger.info("-------------------------------------");
	   }
}

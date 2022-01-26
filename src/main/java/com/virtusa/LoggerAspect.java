package com.virtusa;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	private Logger logger=Logger.getLogger(LoggerAspect.class);
	@Pointcut("execution(* com.virtusa.*.*.*(..))")
	private void getPointCut()
	{
		
	}
	@Before(value = "getPointCut()")
	public void infoLog(JoinPoint joinPoint)
	{
		logger.info(joinPoint.getTarget().getClass().getSimpleName()+" :MethodName: "+joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "getPointCut() throws Exception" , throwing = "ex")
	public void handleExceptionLog(JoinPoint joinPoint,Exception ex)
	{
		logger.error(joinPoint.getTarget().getClass().getSimpleName()+" :MethodName: "+joinPoint.getSignature().getName()
				+" :ExceptionName: "+ex.getMessage());
	}

}

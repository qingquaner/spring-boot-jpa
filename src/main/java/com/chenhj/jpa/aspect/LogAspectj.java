package com.chenhj.jpa.aspect;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chenhj.jpa.utils.DateTimeUtil;

@Aspect
@Component
public class LogAspectj {
	
	private static Logger logger = LoggerFactory.getLogger(LogAspectj.class);
	private String nowTime = DateTimeUtil.formatDate1(new Date());
	/**
	 * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码. 
	 * 使用 @Pointcut 来声明切入点表达式. 
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式. 
	 */
	@Pointcut("execution (* com.chenhj.jpa.service.*.*(..))")
	public void declareJointPointExpression(){}
	
	@Before("declareJointPointExpression()")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		
		logger.info(nowTime+"-"+methodName+":"+args);
	}
	
	@After("declareJointPointExpression()")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		logger.info(nowTime+"-The method " + methodName + " ends");
	}
	
	@AfterReturning(value="declareJointPointExpression()",returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		String methodName = joinPoint.getSignature().getName();
		logger.info(nowTime+"-The method " + methodName + " ends with " + result);
	}
	
	/**
	 * 在目标方法出现异常时会执行的代码.
	 * 可以访问到异常对象; 且可以指定在出现特定异常时在执行通知代码
	 */
	@AfterThrowing(value="declareJointPointExpression()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e){
		String methodName = joinPoint.getSignature().getName();
		logger.info(nowTime+"-The method " + methodName + " occurs excetion:" + e);
	}
}

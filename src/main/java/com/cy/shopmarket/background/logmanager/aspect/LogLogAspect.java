package com.cy.shopmarket.background.logmanager.aspect;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cy.shopmarket.background.logmanager.service.LogLogService;
import com.cy.shopmarket.common.annotation.AddLoggingAnnotation;
import com.cy.shopmarket.common.pojo.Log;
import com.cy.shopmarket.common.util.IPUtils;

/**
 * 	扩展切面动态添加日志
 */
//@Aspect
//@Component
public class LogLogAspect {
	
	@Pointcut("@annotation(com.cy.shopmarket.common.annotation.AddLoggingAnnotation)")
	public void doLoggingAdd() {}
	
	@Autowired
	private LogLogService logLogService;
	
	@Around("doLoggingAdd()")
	public Object aroundAddLog(ProceedingJoinPoint pj) throws Throwable {
		long time = System.currentTimeMillis();
		Object result = pj.proceed();
		time = System.currentTimeMillis()-time;
		//实现切面储存到数据库
		addLogging(pj,time);
		return result;
	}

	private void addLogging(ProceedingJoinPoint pj, long time)throws Exception{
		
		//获取目标方法信息
		MethodSignature mSignature = (MethodSignature) pj.getSignature();
		
		//获取字节码
		Class<?> targetClass = pj.getTarget().getClass();
		//获取方法
		Method targetMethod = 
				targetClass.getDeclaredMethod(mSignature.getName(), mSignature.getParameterTypes());
		//获取注解
		AddLoggingAnnotation logAnn =
				targetMethod.getAnnotation(AddLoggingAnnotation.class);
		//获取操作名
		String operation = logAnn.operation();
		//获取操作id
		int operationId = logAnn.operationId();
		
		//获取方法名
		String logType = targetClass.getName();
		String methodName = mSignature.getName();
		String targetClassMethodMethod = logType+"."+methodName;
		
		//获取方法参数
		String params = Arrays.toString(pj.getArgs());
		
		//对信息封装
		Log log = new Log();
		log.setUsername("admin");
		log.setOperation(operation);
		log.setMethod(targetClassMethodMethod);
		log.setParam(params);
		log.setTime(time);
		log.setIp(IPUtils.getIpAddr());
		log.setCreatetime(new Date());
		log.setOperationId(operationId);
		logLogService.insertLogAddObject(log);
	}
}





























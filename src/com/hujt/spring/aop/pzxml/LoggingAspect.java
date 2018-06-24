package com.hujt.spring.aop.pzxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 把这个类声明为一个切面：先将类放入IOC容器中，再将它声明为一个切面
 * 日志切面
 */


public class LoggingAspect {

	/**
	 * 声明该方法是一个前置通知：在目标方法开始之前执行
	 * @param joinpoint:连接点
	 * execution：声明该通知位于哪个方法的执行前
     */
	public void beforeMethod(JoinPoint joinpoint){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();
		//获取参数
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("前置通知：The method " + methodName + " begins");
	}

	/**
	 * 后置通知：在目标方法执行后（无论是否发生异常）执行的通知
	 * 在后置通知里不能访问的执行结果
	 */
	public void afterMethod(JoinPoint joinpoint){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();

		System.out.println("后置通知：The method " + methodName + " ends");
	}

	/**
	 * 返回通知：可以访问到方法的返回值（在方法正常执行结束后受执行的代码）
	 */
	public void afterReturning(JoinPoint joinpoint, Object result){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();

		System.out.println("返回通知：The method " + methodName + " ends with " + result);
	}

	/**
	 * 异常通知：方法出现异常时才会执行的通知
	 * 返回异常对象：且可以指定需要返回异常的类型
	 */
	public void afterThrowing(JoinPoint joinpoint, Exception ex){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();

		System.out.println("异常通知：The method " + methodName + " occurs exception " + ex);
	}

	/**
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数
	 * 类似于动态代理的全过程，ProceedingJoinPoint参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值必为目标方法的返回值
	 */
/*	public Object aroundMethod(ProceedingJoinPoint pjp){
		Object result = null;
		String methodName = pjp.getSignature().getName();

		//执行目标方法
		try{
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			//返回通知
			System.out.println("The method ends with " + result);
		}catch(Throwable e){
			//异常通知
			System.out.println("The method occurs exception " + e);
			throw new RuntimeException(e);
		}finally{
			//后置通知
			System.out.println("The method ends with " + result);
		}
		return result;
	}*/

}

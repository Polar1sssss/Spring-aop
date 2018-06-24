package com.hujt.spring.aop.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 把这个类声明为一个切面：先将类放入IOC容器中，再将它声明为一个切面
 * 日志切面
 */

@Order(2)
@Aspect
@Component
public class LoggingAspect {

	/**
	 * 声明切入点表达式
	 * 出现error at ::0 can't find referenced pointcut...这样的错误原因是：如果你用的JDK版本是1.6的话，
	 * 而引用的aspectjrt.jar是spring-2.0中包含的jar包的情况下就会报这样的错误。
	 * 解决的办法就是下载最新的aspectjrt的jar包即可aspectj-1.6.6.jar
	 */
	@Pointcut("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression(){}

	/**
	 * 声明该方法是一个前置通知：在目标方法开始之前执行
	 * @param joinpoint:切入点
	 * execution：声明该通知位于哪个方法的执行前
     */
	@Before("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinpoint){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();
		//获取参数
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method " + methodName + " begins");
	}

	/**
	 * 后置通知：在目标方法执行后（无论是否发生异常）执行的通知
	 * 在后置通知里不能访问的执行结果
	 */
	@After("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinpoint){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends");
	}

	/**
	 * 返回通知：可以访问到方法的返回值（在方法正常执行结束后受执行的代码）
	 */
	@AfterReturning(value="execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinpoint, Object result){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends with " + result);
	}

	/**
	 * 异常通知：方法出现异常时才会执行的通知
	 * 返回异常对象：且可以指定需要返回异常的类型
	 */
	@AfterThrowing(value="execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))",
			throwing="ex")
	public void afterThrowing(JoinPoint joinpoint, Exception ex){
		//获取方法名
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The method " + methodName + " occurs exception " + ex);
	}

	/**
	 * 环绕通知需要携带ProceedingJoinPoint类型的参数
	 * 类似于动态代理的全过程，ProceedingJoinPoint参数可以决定是否执行目标方法
	 * 且环绕通知必须有返回值，返回值必为目标方法的返回值
	 */
	/*@Around("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp){
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

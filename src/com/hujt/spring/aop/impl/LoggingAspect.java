package com.hujt.spring.aop.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * �����������Ϊһ�����棺�Ƚ������IOC�����У��ٽ�������Ϊһ������
 * ��־����
 */

@Order(2)
@Aspect
@Component
public class LoggingAspect {

	/**
	 * �����������ʽ
	 * ����error at ::0 can't find referenced pointcut...�����Ĵ���ԭ���ǣ�������õ�JDK�汾��1.6�Ļ���
	 * �����õ�aspectjrt.jar��spring-2.0�а�����jar��������¾ͻᱨ�����Ĵ���
	 * ����İ취�����������µ�aspectjrt��jar������aspectj-1.6.6.jar
	 */
	@Pointcut("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression(){}

	/**
	 * �����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 * @param joinpoint:�����
	 * execution��������֪ͨλ���ĸ�������ִ��ǰ
     */
	@Before("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinpoint){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();
		//��ȡ����
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The method " + methodName + " begins");
	}

	/**
	 * ����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣��ִ�е�֪ͨ
	 * �ں���֪ͨ�ﲻ�ܷ��ʵ�ִ�н��
	 */
	@After("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinpoint){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends");
	}

	/**
	 * ����֪ͨ�����Է��ʵ������ķ���ֵ���ڷ�������ִ�н�������ִ�еĴ��룩
	 */
	@AfterReturning(value="execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))",
			returning="result")
	public void afterReturning(JoinPoint joinpoint, Object result){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The method " + methodName + " ends with " + result);
	}

	/**
	 * �쳣֪ͨ�����������쳣ʱ�Ż�ִ�е�֪ͨ
	 * �����쳣�����ҿ���ָ����Ҫ�����쳣������
	 */
	@AfterThrowing(value="execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))",
			throwing="ex")
	public void afterThrowing(JoinPoint joinpoint, Exception ex){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();

		System.out.println("The method " + methodName + " occurs exception " + ex);
	}

	/**
	 * ����֪ͨ��ҪЯ��ProceedingJoinPoint���͵Ĳ���
	 * �����ڶ�̬�����ȫ���̣�ProceedingJoinPoint�������Ծ����Ƿ�ִ��Ŀ�귽��
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 */
	/*@Around("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp){
		Object result = null;
		String methodName = pjp.getSignature().getName();

		//ִ��Ŀ�귽��
		try{
			//ǰ��֪ͨ
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			//����֪ͨ
			System.out.println("The method ends with " + result);
		}catch(Throwable e){
			//�쳣֪ͨ
			System.out.println("The method occurs exception " + e);
			throw new RuntimeException(e);
		}finally{
			//����֪ͨ
			System.out.println("The method ends with " + result);
		}
		return result;
	}*/

}

package com.hujt.spring.aop.pzxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * �����������Ϊһ�����棺�Ƚ������IOC�����У��ٽ�������Ϊһ������
 * ��־����
 */


public class LoggingAspect {

	/**
	 * �����÷�����һ��ǰ��֪ͨ����Ŀ�귽����ʼ֮ǰִ��
	 * @param joinpoint:���ӵ�
	 * execution��������֪ͨλ���ĸ�������ִ��ǰ
     */
	public void beforeMethod(JoinPoint joinpoint){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();
		//��ȡ����
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("ǰ��֪ͨ��The method " + methodName + " begins");
	}

	/**
	 * ����֪ͨ����Ŀ�귽��ִ�к������Ƿ����쳣��ִ�е�֪ͨ
	 * �ں���֪ͨ�ﲻ�ܷ��ʵ�ִ�н��
	 */
	public void afterMethod(JoinPoint joinpoint){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();

		System.out.println("����֪ͨ��The method " + methodName + " ends");
	}

	/**
	 * ����֪ͨ�����Է��ʵ������ķ���ֵ���ڷ�������ִ�н�������ִ�еĴ��룩
	 */
	public void afterReturning(JoinPoint joinpoint, Object result){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();

		System.out.println("����֪ͨ��The method " + methodName + " ends with " + result);
	}

	/**
	 * �쳣֪ͨ�����������쳣ʱ�Ż�ִ�е�֪ͨ
	 * �����쳣�����ҿ���ָ����Ҫ�����쳣������
	 */
	public void afterThrowing(JoinPoint joinpoint, Exception ex){
		//��ȡ������
		String methodName = joinpoint.getSignature().getName();

		System.out.println("�쳣֪ͨ��The method " + methodName + " occurs exception " + ex);
	}

	/**
	 * ����֪ͨ��ҪЯ��ProceedingJoinPoint���͵Ĳ���
	 * �����ڶ�̬�����ȫ���̣�ProceedingJoinPoint�������Ծ����Ƿ�ִ��Ŀ�귽��
	 * �һ���֪ͨ�����з���ֵ������ֵ��ΪĿ�귽���ķ���ֵ
	 */
/*	public Object aroundMethod(ProceedingJoinPoint pjp){
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

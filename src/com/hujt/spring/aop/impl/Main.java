package com.hujt.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//����Spring IOC����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//��IOC�����л�ȡBean��ʵ��
		ArithmeticCalculator ac = ctx.getBean(ArithmeticCalculator.class);
		//ʹ��Bean
		int result = ac.add(1, 2);
		System.out.println("result:" + result);
		System.out.println("----------------------------------------------");
		int result1 = ac.div(10, 1);
		System.out.println("result:" + result1);
	}
}

package com.hujt.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//创建Spring IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从IOC容器中获取Bean的实例
		ArithmeticCalculator ac = ctx.getBean(ArithmeticCalculator.class);
		//使用Bean
		int result = ac.add(1, 2);
		System.out.println("result:" + result);
		System.out.println("----------------------------------------------");
		int result1 = ac.div(10, 1);
		System.out.println("result:" + result1);
	}
}

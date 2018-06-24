package com.hujt.spring.aop.helloworld;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator acp = new ArithmeticCalculatorProxy(target).getLoggingProxy();
		
		System.out.println(acp.add(1, 2));
		System.out.println(acp.sub(1, 2));
		System.out.println(acp.mul(1, 2));
		System.out.println(acp.div(1, 2));
	}
	
}

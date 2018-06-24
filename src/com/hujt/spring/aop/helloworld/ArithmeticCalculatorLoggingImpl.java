package com.hujt.spring.aop.helloworld;

public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("The method add begins with [" + i + "," + j + "]");
		// TODO Auto-generated method stub
		int result = i + j;
		System.out.println("The method add begins with [" + result + "]");
		return result;
		
	}

	@Override
	public int sub(int i, int j) {
		
		// TODO Auto-generated method stub
		System.out.println("The method sub begins with [" + i + "," + j + "]");
		int result = i - j;
		System.out.println("The method sub begins with [" + i + "," + j + "]");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The method mul begins with [" + i + "," + j + "]");
		int result = i * j;
		System.out.println("The mul add begins with [" + i + "," + j + "]");
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("The method div begins with [" + i + "," + j + "]");
		int result = i / j;
		System.out.println("The method div begins with [" + i + "," + j + "]");
		return result;
	}

}

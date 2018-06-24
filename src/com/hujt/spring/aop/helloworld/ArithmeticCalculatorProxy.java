package com.hujt.spring.aop.helloworld;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorProxy {
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorProxy(ArithmeticCalculator target){
		this.target = target;
	}
	
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy = null;
		
		//�����������һ����������������
		ClassLoader loader = target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class [] interfaces = new Class[]{ArithmeticCalculator.class};
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler h = new InvocationHandler(){
			/**
			 * proxy�����ڷ��ص��Ǹ��������һ�������invoke�����в�ʹ�øö���
			 * method�����ڱ����õķ���
			 * args�����÷����Ǵ���Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String name = method.getName();
				// ��־
				System.out.println("method name: " + name + " begins with " + Arrays.asList(args));
				// ִ�з���
				Object result = method.invoke(target, args);
				// ��־
				System.out.println("method name: " + name + " ends with " + result);
				return result;
			}
			
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}

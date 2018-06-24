package com.hujt.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/6/23.
 * 验证切面
 */

@Order(3)
@Aspect
@Component
public class ValidationAspect {
    @Before("execution(public int com.hujt.spring.aop.impl.ArithmeticCalculator.*(..))")
    public void validateArgs(JoinPoint jp){
        System.out.println("validation : " + Arrays.asList(jp.getArgs()));
    }
}

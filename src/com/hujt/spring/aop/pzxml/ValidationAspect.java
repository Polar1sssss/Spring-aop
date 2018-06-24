package com.hujt.spring.aop.pzxml;

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

public class ValidationAspect {
    public void validateArgs(JoinPoint jp){
        System.out.println("validation : " + Arrays.asList(jp.getArgs()));
    }
}

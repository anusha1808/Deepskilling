package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.library.service.*.*(..))")
    public void serviceMethods(){}

    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before: " + joinPoint.getSignature().getName());
    }

    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After: " + joinPoint.getSignature().getName());
    }

}

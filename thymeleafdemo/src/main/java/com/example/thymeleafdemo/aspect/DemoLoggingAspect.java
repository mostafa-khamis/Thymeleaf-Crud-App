package com.example.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}


    @Pointcut("execution(* com.example.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.example.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forDaoPackage() || forControllerPackage() || forServicePackage()")
    private void appFlow(){}

    @Before("appFlow()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("Method " +method);

        Object[] args = joinPoint.getArgs();
        for (Object arg:args) {
            System.out.println("Argument for "+method+ " is : "+arg);
        }
    }

    @AfterReturning(pointcut = "appFlow()",
                    returning = "result")
    public void after(JoinPoint joinPoint , Object result){
        String method = joinPoint.getSignature().toShortString();
        logger.info("Method " +method);

        logger.info("Result : " + result);
    }
}

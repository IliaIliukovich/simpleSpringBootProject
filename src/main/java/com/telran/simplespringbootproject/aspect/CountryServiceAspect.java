package com.telran.simplespringbootproject.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CountryServiceAspect {


    @Pointcut("execution(public * com.telran.simplespringbootproject.service.CountryService.findGeorgia()))")
    public void method() {}

    @Around("method()")
    public Object specialTransaction(ProceedingJoinPoint joinPoint) {
        System.out.println("Special Transaction start");
//        boolean condition = false;
        boolean condition = true;
        try {
            if (condition) {
                Object methodResult = joinPoint.proceed();
                return methodResult;
            } else {
                System.out.println("Alternative logic");
            }
        } catch (Throwable e) {
            System.out.println("Special logic for exceptions");
            System.out.println("Special Transaction rollback");
        } finally {
            System.out.println("Special Transaction end");
        }
        return null;
    }


}

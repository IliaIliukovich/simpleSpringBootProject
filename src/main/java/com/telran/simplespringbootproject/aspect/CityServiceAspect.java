package com.telran.simplespringbootproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CityServiceAspect {

//    @Pointcut("execution(public void com.telran.simplespringbootproject.service.CityService.getSpecialCity())")
//    public void method() {}
    @Pointcut("within(com.telran.simplespringbootproject.service..*)")
    public void method() {}

    @Before("method()")
    public void notifyOnMethodInvocation(JoinPoint joinPoint) {
        System.out.println("service layer method was invoked");
    }


}

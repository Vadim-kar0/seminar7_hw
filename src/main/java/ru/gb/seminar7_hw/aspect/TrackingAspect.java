package ru.gb.seminar7_hw.aspect;


import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Log
public class TrackingAspect {
    @Before("@annotation(ru.gb.seminar7_hw.aspect.TrackUserAction)")
    public Object logMethods(JoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method= signature.getMethod();
        log.info("\nUser: " + SecurityContextHolder.getContext().getAuthentication().getName() +
                "\nCall method: " + method.getName());
        return joinPoint;
    }
}

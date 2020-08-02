package com.example.exam.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
   

    /**
     * Pointcut that matches all Spring beans in the application's main packages.
     * 
     * Excluding jwt package because logging methods in JwtRequestFilter gives NullPointerException
     */
    @Pointcut("within(com.example.exam..*) && !within(com.example.exam.jwt..*)" )
    public void applicationPackagePointcut() {
    }

   

    /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    @Around("applicationPackagePointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {    	
        
    	log.debug("\n\tEnter: {}.{}() with \n \t\targument[s] = {}", 
        		joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), 
                Arrays.toString(joinPoint.getArgs()));
        
        Object result = joinPoint.proceed();

        log.debug("\n\tExit: {}.{}() with \n \t\tresult = {}", 
        		joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), result);

        return result;
    }
}
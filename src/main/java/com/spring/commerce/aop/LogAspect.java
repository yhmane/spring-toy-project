package com.spring.commerce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hwang-yunho on 2020. 2. 23.
 * @project commerce
 */
@Aspect
@Component
public class LogAspect {
    Logger logger =  LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.spring.commerce.*.*.*(..) )")
    public Object logging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info(pjp.getSignature().getDeclaringTypeName() + " /" + pjp.getSignature().getName() + " started");
        Object result = pjp.proceed();
        logger.info(pjp.getSignature().getDeclaringTypeName() + " /" + pjp.getSignature().getName() + " ended");
        return result;
    }
}

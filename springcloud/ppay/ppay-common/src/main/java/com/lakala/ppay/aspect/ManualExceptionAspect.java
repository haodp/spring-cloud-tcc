package com.lakala.ppay.aspect;

import com.lakala.ppay.config.ManualExceptionProperties;
import com.lakala.ppay.exception.ManualException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author user
 */
@Aspect
public class ManualExceptionAspect implements Ordered {
    private final int order;
    private final ManualExceptionProperties properties;
    private static final Random RANDOM = new SecureRandom();

    public ManualExceptionAspect(int order, ManualExceptionProperties properties) {
        this.order = order;
        this.properties = properties;
    }

    @Around("@annotation(com.lakala.ppay.RandomlyThrowsException)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        if (properties.isEnabled()) {
            if (RANDOM.nextInt(100) % properties.getFactor() == 0) {
                throw new ManualException("manual exception");
            }
        }
        return joinPoint.proceed();
    }

    @Override
    public int getOrder() {
        return order;
    }
}

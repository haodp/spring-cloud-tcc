package com.lakala.ppay.aspect;

import com.lakala.ppay.config.RequestAttributeConst;
import com.lakala.ppay.web.ServletContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;

import javax.servlet.http.HttpServletResponse;

/**
 * @author user
 */
@Aspect
public class RequestIdStuffAspect implements Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestIdStuffAspect.class);
    private final int order;

    public RequestIdStuffAspect(int order) {
        this.order = order;
    }

    @Before(value = "within(com.lakala.ppay..*) " +
            "&& (@annotation(org.springframework.web.bind.annotation.ResponseBody)" +
            "|| @annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public void before(JoinPoint joinPoint) {
        final String requestId = ServletContextHolder.fetchRequestId();
        final HttpServletResponse response = ServletContextHolder.getResponse();
        if (response.getHeader(RequestAttributeConst.REQUEST_ID) == null) {
            response.addHeader(RequestAttributeConst.REQUEST_ID, requestId);
        }
    }

    @Override
    public int getOrder() {
        return order;
    }
}

package com.lakala.ppay.config;

import com.lakala.ppay.aspect.HibernateValidatorAspect;
import com.lakala.ppay.controller.StatusCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author user
 */
@Configuration
public class AopConfiguration {

    @Bean
    public HibernateValidatorAspect hibernateValidatorAspect() {
        final int order = Byte.MAX_VALUE + 2;
        return new HibernateValidatorAspect(order, StatusCode.INVALID_MODEL_FIELDS);
    }

}

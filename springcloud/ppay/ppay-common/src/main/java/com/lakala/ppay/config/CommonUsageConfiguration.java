package com.lakala.ppay.config;

import com.lakala.ppay.aspect.DelayReturnAspect;
import com.lakala.ppay.aspect.HibernateValidatorAspect;
import com.lakala.ppay.aspect.ManualExceptionAspect;
import com.lakala.ppay.aspect.RequestIdStuffAspect;
import com.lakala.ppay.aspect.RequestLoggingAspect;
import com.lakala.ppay.web.filter.ResettableRequestFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

/**
 * @author user
 */
@Configuration
@EnableConfigurationProperties({DelayProperties.class, ManualExceptionProperties.class})
public class CommonUsageConfiguration {
    @Bean
    public DelayReturnAspect delayReturnAspect(DelayProperties properties) {
        return new DelayReturnAspect(Ordered.LOWEST_PRECEDENCE, properties);
    }

    @Bean
    public ManualExceptionAspect manualExceptionAspect(ManualExceptionProperties properties) {
        return new ManualExceptionAspect(Ordered.LOWEST_PRECEDENCE - 1, properties);
    }

    @Bean
    public ResettableRequestFilter resettableRequestFilter() {
        return new ResettableRequestFilter();
    }

    @Bean
    public RequestIdStuffAspect idStuffAspect() {
        final int order = Byte.MAX_VALUE;
        return new RequestIdStuffAspect(order);
    }

    @Bean
    public RequestLoggingAspect logsAspect() {
        final int order = Byte.MAX_VALUE + 1;
        return new RequestLoggingAspect(order);
    }

    @Bean
    @ConditionalOnMissingBean
    public HibernateValidatorAspect hibernateValidatorAspect() {
        final int order = Byte.MAX_VALUE + 2;
        return new HibernateValidatorAspect(order);
    }

}

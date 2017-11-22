package com.lakala.ppay.controller;

import com.lakala.ppay.web.ServletContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

/**
 * @author user
 */
public class TccResponseErrorHandler implements ResponseErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TccResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        // always ingore exception
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        LOGGER.info("request id '{}' error response '{}'", ServletContextHolder.fetchRequestId(), response);
    }
}

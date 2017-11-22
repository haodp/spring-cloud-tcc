package com.lakala.ppay;

import lombok.Value;

/**
 * @author user
 */
@Value
public class MessageRoute {
    private String exchange;

    private String routeKey;
}

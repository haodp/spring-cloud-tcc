package com.lakala.ppay.domain.type.handler;

import com.lakala.ppay.domain.type.EventStatus;

/**
 * @author user
 */
public class EventStatusTypeHandler extends GenericTypeHandler<EventStatus> {
    @Override
    public int getEnumIntegerValue(EventStatus parameter) {
        return parameter.getStatus();
    }
}

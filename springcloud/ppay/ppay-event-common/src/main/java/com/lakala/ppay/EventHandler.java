package com.lakala.ppay;

import com.lakala.ppay.domain.EventSubscriber;
import com.lakala.ppay.persistence.EventSubscriberMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author user
 */
public abstract class EventHandler {
    @Autowired
    private EventSubscriberMapper mapper;

    public EventSubscriberMapper getMapper() {
        return mapper;
    }

    public void setMapper(EventSubscriberMapper mapper) {
        this.mapper = mapper;
    }

    public abstract void handle(EventSubscriber subscriber);
}

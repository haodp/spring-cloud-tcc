package com.lakala.ppay;

import com.lakala.ppay.domain.EventPublisher;
import com.lakala.ppay.persistence.EventPublisherMapper;

import java.util.Set;

/**
 * @author user
 */
public interface BatchFetchEventStrategy {
    Set<EventPublisher> execute(EventPublisherMapper mapper);
}

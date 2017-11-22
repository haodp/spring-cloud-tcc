package com.lakala.ppay;

import com.lakala.ppay.domain.EventPublisher;
import com.lakala.ppay.domain.type.EventStatus;
import com.lakala.ppay.persistence.EventPublisherMapper;

import java.util.Set;

/**
 * @author user
 */
public enum PublishNewEventStrategy implements BatchFetchEventStrategy {
    SINGLETON;

    @Override
    public Set<EventPublisher> execute(EventPublisherMapper mapper) {
        return mapper.selectLimitedEntityByEventStatus(EventStatus.NEW, 300);
    }
}

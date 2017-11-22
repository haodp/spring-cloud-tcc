package com.lakala.ppay;

import com.lakala.ppay.domain.EventPublisher;
import com.lakala.ppay.domain.type.EventStatus;
import com.lakala.ppay.persistence.EventPublisherMapper;

import java.time.OffsetDateTime;
import java.util.Set;

/**
 * @author user
 */
public enum RepublishPendingEventStrategy implements BatchFetchEventStrategy {
    SINGLETON;

    @Override
    public Set<EventPublisher> execute(EventPublisherMapper mapper) {
        // 取出3秒前已经发送过至队列但是没有收到ack请求的消息，并进行重试
        return mapper.selectLimitedEntityByEventStatusBeforeTheSpecifiedUpdateTime(EventStatus.PENDING, 300, OffsetDateTime.now().minusSeconds(3));
    }
}

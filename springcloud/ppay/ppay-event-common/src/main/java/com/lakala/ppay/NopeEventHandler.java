package com.lakala.ppay;

import com.lakala.ppay.domain.EventSubscriber;
import com.lakala.ppay.domain.type.EventStatus;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author user
 */
public class NopeEventHandler extends EventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(NopeEventHandler.class);

    @Override
    public void handle(EventSubscriber subscriber) {
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(subscriber.getId());
        if (getMapper().updateEventStatusByPrimaryKeyInCasMode(subscriber.getId(), EventStatus.NEW, EventStatus.NOT_FOUND) > 0) {
            LOGGER.error("event which id is {} has to change status from NEW to NOT_FOUND due to threr is not a match handler.", subscriber.getId());
        }
    }

}

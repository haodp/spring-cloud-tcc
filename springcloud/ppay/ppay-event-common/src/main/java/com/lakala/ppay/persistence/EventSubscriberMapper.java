package com.lakala.ppay.persistence;

import com.lakala.ppay.MyBatisRepository;
import com.lakala.ppay.domain.EventSubscriber;
import com.lakala.ppay.domain.type.EventStatus;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@SuppressWarnings("InterfaceNeverImplemented")
@MyBatisRepository
public interface EventSubscriberMapper extends CrudMapper<EventSubscriber> {

    int updateEventStatusByPrimaryKeyInCasMode(@Param("id") Long id, @Param("expect") EventStatus expect, @Param("target") EventStatus target);

}
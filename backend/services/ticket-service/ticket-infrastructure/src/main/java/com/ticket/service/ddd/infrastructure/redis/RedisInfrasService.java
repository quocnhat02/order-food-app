package com.ticket.service.ddd.infrastructure.redis;

import java.util.concurrent.TimeUnit;

public interface RedisInfrasService {
    void setString(String key, String value);
    String getString(String key);

    void setObject(String key, Object value);
    <T> T getObject(String key, Class<T> targetClass);

//    void setStringWithTTL(String key, String value, long ttl, TimeUnit unit);
//
//    void setObjectWithTTL(String key, Object value, long ttl, TimeUnit unit);
}

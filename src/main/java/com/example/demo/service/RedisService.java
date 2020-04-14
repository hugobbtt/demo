package com.example.demo.service;

import java.util.Map;

public interface RedisService {

    void set(String key, String value);

    void set(String key, Object value);

    void set(String key, Object value, long time);

    Object get(String key);

    Boolean del(String key);

    /**
     *设置过期时间
     */
    Boolean expire(String key, long expire);

    /**
     * 获取过期时间
     */
    Long getExpire(String key);

    /**
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

    void hSetAll(String key, Map<String, Object> value);

    Map<Object, Object> hGetAll(String key);

}

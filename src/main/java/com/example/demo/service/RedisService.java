package com.example.demo.service;

public interface RedisService {

    void set(String key, String value);

    String get(String key);

    boolean expire(String key, long expire);

    void remove(String key);

    /**
     * @param delta 自增步长
     */
    Long increment(String key, long delta);
}

package com.ly.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class AddService {
    public static final String addKey="SpringBoot:Redis:Test:Add";

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public void add(Integer id) throws Exception{
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(addKey,id.toString());

    }
}

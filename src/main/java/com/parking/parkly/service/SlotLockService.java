package com.parking.parkly.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class SlotLockService {

    private final RedisTemplate<String, String> redisTemplate;

    public boolean lockSlot(String slotId, String userId) {

        String key = "booking:slot:" + slotId;

        Boolean locked = redisTemplate.opsForValue().setIfAbsent(
                key,
                userId,
                5,
                TimeUnit.MINUTES
        );

        return Boolean.TRUE.equals(locked);
    }

    public void releaseSlot(String slotId) {

        String key = "booking:slot:" + slotId;

        redisTemplate.delete(key);
    }
}
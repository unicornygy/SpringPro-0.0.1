package com.unicorn.service;

import com.unicorn.util.JedisAdapter;
import com.unicorn.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    JedisAdapter jedisAdapter;

    public int getLikeStatus(int userId, int entityType, int entityId) {
        String likeKey = RedisKeyUtil.getLikeKey(entityId, entityType);
        if (jedisAdapter.sismember(likeKey, String.valueOf(userId))) {
            return 1;
        }
        String disLikeKey = RedisKeyUtil.getDislikeKey(entityId, entityType);
        return jedisAdapter.sismember(disLikeKey, String.valueOf(userId)) ? -1 : 0;
    }

    public long like(int userId, int entityType, int entityId) {
        String likeKey = RedisKeyUtil.getLikeKey(entityId, entityType);
        jedisAdapter.sadd(likeKey, String.valueOf(likeKey));

        String dislikeKey = RedisKeyUtil.getDislikeKey(entityId, entityType);
        jedisAdapter.srem(dislikeKey, String.valueOf(dislikeKey));

        return jedisAdapter.scard(likeKey);
    }

    public long dislike(int userId, int entityType, int entityId) {
        String dislikeKey = RedisKeyUtil.getDislikeKey(entityId, entityType);
        jedisAdapter.sadd(dislikeKey, String.valueOf(dislikeKey));

        String likeKey = RedisKeyUtil.getLikeKey(entityId, entityType);
        jedisAdapter.srem(likeKey, String.valueOf(likeKey));

        return jedisAdapter.scard(dislikeKey);
    }
}

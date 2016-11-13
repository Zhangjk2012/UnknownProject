package com.zhang.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by zjk on 13/11/16.
 */
@Component
public class RedisExecutor {

    private static Logger logger = LoggerFactory.getLogger(RedisExecutor.class);

    @Resource(name="shardedJedisPool")
    private ShardedJedisPool redisPool;

    public void set(String key, String value) {
        ShardedJedis jedis = null;
        try {
            logger.info("Set the {},the value {}",key,value);
            Optional<ShardedJedis> opt = getJedis();
            if (opt.isPresent()) {
                jedis = opt.get();
                jedis.set(key,value);
            } else {
                logger.warn("Get the Jedis error.");
            }
        } finally {
            returnJedis(jedis);
        }
    }


    /**
     * 获取一个SharedJedis。
     * @return Optional对象
     */
    private Optional<ShardedJedis> getJedis() {
        ShardedJedis jedis = null;
        try {
            jedis = redisPool.getResource();
        } catch (Exception e) {
            logger.error("Get the shared jedis error.",e);
        }
        return Optional.of(jedis);
    }

    private void returnJedis(ShardedJedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}

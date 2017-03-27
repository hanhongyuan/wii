package com.platform.common.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by tanghong on 2017/2/21.
 */
@Configuration
@PropertySource("classpath:application.yml")
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    String host;

    @Value("${spring.redis.port}")
    int port;

    @Value("${spring.redis.password}")
    String password;

    @Bean(name="jedisPool")
    public JedisPool redisPoolFactory(){
        int timeout = 60000;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8); // max idle connect
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxWaitMillis(-1);
        jedisPoolConfig.setTestOnBorrow(true); // ping of get connect
        return new JedisPool(jedisPoolConfig, host, port, timeout, password, 0);
    }

}

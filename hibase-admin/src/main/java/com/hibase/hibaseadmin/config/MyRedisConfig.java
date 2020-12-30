package com.hibase.hibaseadmin.config;


import com.hibase.common.web.redis.RedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class MyRedisConfig extends RedisConfig {

}
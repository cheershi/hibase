package com.hibase.hibaseadmin;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.hibase.hibaseweb.annotation.EnableHibaseBasic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHibaseBasic
// jetcache 注解
@EnableMethodCache(basePackages = "com.hibase.hibaseadmin")
@EnableCreateCacheAnnotation
public class HibaseAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibaseAdminApplication.class, args);
    }

}

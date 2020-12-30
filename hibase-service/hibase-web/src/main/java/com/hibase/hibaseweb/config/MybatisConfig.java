package com.hibase.hibaseweb.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    /**
     * 逻辑删除
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new MyLogicSqlInjector();
    }
}

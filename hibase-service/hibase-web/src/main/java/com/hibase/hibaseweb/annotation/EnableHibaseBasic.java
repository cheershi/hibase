package com.hibase.hibaseweb.annotation;


import com.hibase.hibaseweb.config.MybatisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 开启hibase基础功能
 *
 * @author hufeng
 * @date 2018/12/19
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {java.lang.annotation.ElementType.TYPE})
@Documented
@Import({MybatisConfig.class, GlobalRequestAspect.class})
public @interface EnableHibaseBasic {
}

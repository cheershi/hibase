package com.hibase.common.core.util;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Optional;

/**
 * 获取用户信息
 * @author 陈丰
 */
public class UserContextHolder {

    private ThreadLocal<Map<String, String>> threadLocal;

    private UserContextHolder() {
        this.threadLocal = new ThreadLocal<>();
    }

    /**
     * 创
     *
     * @return
     */
    public static UserContextHolder getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     *
     * 单
     */
    private static class SingletonHolder {
        private static final UserContextHolder sInstance = new UserContextHolder();
    }

    /**
     *
     *
     * @param map
     */
    public void setContext(Map<String, String> map) {
        threadLocal.set(map);
    }

    /**
     * 获
     *
     * @return
     */
    public Map<String, String> getContext() {
        return threadLocal.get();
    }

    /**
     * 获
     *
     * @return
     */
    public String getUsername() {
        return Optional.ofNullable(threadLocal.get()).orElse(Maps.newHashMap()).get("user_name");
    }

    /**
     *
     */
    public void clear() {
        threadLocal.remove();
    }

}

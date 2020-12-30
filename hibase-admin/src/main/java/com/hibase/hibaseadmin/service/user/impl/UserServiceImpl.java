package com.hibase.hibaseadmin.service.user.impl;

import cn.hutool.core.util.StrUtil;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.hibase.hibaseadmin.entity.user.User;
import com.hibase.hibaseadmin.entity.user.vo.UserListVo;
import com.hibase.hibaseadmin.entity.user.vo.UserSearchVo;
import com.hibase.hibaseadmin.entity.user.vo.UserViewVo;
import com.hibase.hibaseadmin.mapper.user.UserMapper;
import com.hibase.hibaseadmin.service.user.UserService;
import com.hibase.hibaseadmin.service.userRoleRelation.UserRoleRelationService;
import com.hibase.hibaseweb.exception.HibaseAssert;
import com.hibase.hibaseweb.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户模块
 */
@Service
@Slf4j
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Cached(name = "user::", key = "#id", cacheType = CacheType.BOTH)
    public UserViewVo get(String id) {
        User user = this.getById(id,false);
        HibaseAssert.notNull(user,"user not found with id:" + id);
        user.setRoleIds(userRoleRelationService.queryByUserId(id));
        return new UserViewVo(user);
    }

    @Override
    @Cached(name = "user::", key = "#uniqueId", cacheType = CacheType.BOTH)
    public User getByUniqueId(String uniqueId) {
        User user = this.getOne(new QueryWrapper<User>()
                .eq("username", uniqueId)
                .or()
                .eq("mobile", uniqueId));
        HibaseAssert.notNull(user,"user not found with uniqueId:" + uniqueId);
        user.setRoleIds(userRoleRelationService.queryByUserId(user.getId()));
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(User user) {
        if(StrUtil.isNotBlank(user.getPassword()))
            user.setPassword(passwordEncoder().encode(user.getPassword()));
        boolean inserts = this.save(user);
        userRoleRelationService.saveBatch(user.getId(), user.getRoleIds());
        return inserts;
    }

    @Override
    public PageInfo<UserListVo> query(UserSearchVo searchVo) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheInvalidate(name = "user::", key = "#user.id")
    public boolean update(User user) {
        if (StrUtil.isNotBlank(user.getPassword()))
            user.setPassword(passwordEncoder().encode(user.getPassword()));
        boolean isSuccess = this.updateById(user);
        userRoleRelationService.saveBatch(user.getId(), user.getRoleIds());
        return isSuccess;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheInvalidate(name = "user::", key = "#id")
    public boolean delete(String id) {
        this.deleteBy(id);
        return userRoleRelationService.removeByUserId(id);
    }
}

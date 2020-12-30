package com.hibase.hibaseadmin.service.user;

import com.github.pagehelper.PageInfo;
import com.hibase.hibaseadmin.entity.user.User;
import com.hibase.hibaseadmin.entity.user.vo.UserListVo;
import com.hibase.hibaseadmin.entity.user.vo.UserSearchVo;
import com.hibase.hibaseadmin.entity.user.vo.UserViewVo;
import com.hibase.hibaseweb.service.BaseService;

public interface UserService extends BaseService<User> {

    /**
     * 获取用户
     *
     * @param id 用户id
     * @return UserVo
     */
    UserViewVo get(String id);

    /**
     * 根据用户唯一标识获取用户信息
     * 目前用户标识不用户名或mobile
     *
     * @param uniqueId
     * @return
     */
    User getByUniqueId(String uniqueId);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     * 查询用户
     *
     * @return
     */
    PageInfo<UserListVo> query(UserSearchVo searchVo);

    /**
     * 更新用户信息
     *
     * @param user
     */
    boolean update(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     */
    boolean delete(String id);
}

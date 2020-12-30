package com.hibase.hibaseadmin.service.userRoleRelation.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.hibase.hibaseadmin.entity.userRoleRelation.UserRoleRelation;
import com.hibase.hibaseadmin.entity.userRoleRelation.vo.UserRoleRelationSearchVO;
import com.hibase.hibaseadmin.mapper.userRoleRelation.UserRoleRelationMapper;
import com.hibase.hibaseadmin.service.userRoleRelation.UserRoleRelationService;
import com.hibase.hibaseweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户和角色关系表 服务实现类
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserRoleRelationServiceImpl extends BaseServiceImpl<UserRoleRelationMapper, UserRoleRelation> implements UserRoleRelationService {

    /**
     * 查询用户和角色关系表列表
     */
    @Override
    public PageInfo<UserRoleRelation> selectUserRoleRelationList(UserRoleRelationSearchVO searchVO) {

        return super.page(searchVO, new QueryWrapper<UserRoleRelation>());
    }

    /**
     * 改变用户和角色关系表记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserRoleRelation(UserRoleRelation entity) {

        super.store(entity);
    }

    /**
     * 查询用户和角色关系表详情
     */
    @Override
    public UserRoleRelation viewUserRoleRelation(String id) {

        UserRoleRelation entity = super.getById(id, true);

        return entity;
    }

    /**
     * 删除用户和角色关系表记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserRoleRelation(String id) {

        super.deleteBy(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(String userId, Set<String> roleIds) {
        if (CollectionUtil.isEmpty(roleIds))
            return false;
        removeByUserId(userId);
        Set<UserRoleRelation> userRoles = roleIds.stream().map(roleId -> new UserRoleRelation(userId, roleId)).collect(Collectors.toSet());
        return saveBatch(userRoles);
    }

    @Override
    public boolean removeByUserId(String userId) {
        QueryWrapper<UserRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserRoleRelation::getUserId, userId);
        return remove(queryWrapper);
    }

    @Override
    public Set<String> queryByUserId(String userId) {
        QueryWrapper<UserRoleRelation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<UserRoleRelation> userRoleList = list(queryWrapper);
        return userRoleList.stream().map(UserRoleRelation::getRoleId).collect(Collectors.toSet());
    }
}

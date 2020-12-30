package com.hibase.hibaseadmin.service.userRoleRelation;

import com.github.pagehelper.PageInfo;
import com.hibase.hibaseadmin.entity.userRoleRelation.UserRoleRelation;
import com.hibase.hibaseadmin.entity.userRoleRelation.vo.UserRoleRelationSearchVO;
import com.hibase.hibaseweb.service.BaseService;

import java.util.Set;

/**
 * <p>
 * 用户和角色关系表 服务类
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
public interface UserRoleRelationService extends BaseService<UserRoleRelation> {

    /**
     * 查询用户和角色关系表列表
     *
     * @param searchVO
     * @return
     */
    PageInfo<UserRoleRelation> selectUserRoleRelationList(UserRoleRelationSearchVO searchVO);

    /**
     * 改变用户和角色关系表记录
     *
     * @param entity
     * @return
     */
    void saveUserRoleRelation(UserRoleRelation entity);

    /**
     * 查询用户和角色关系表详情
     *
     * @param id
     * @return
     */
    UserRoleRelation viewUserRoleRelation(String id);

    /**
     * 删除用户和角色关系表
     *
     * @param id
     */
    void deleteUserRoleRelation(String id);

    /**
     * 给用户添加角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    boolean saveBatch(String userId, Set<String> roleIds);

    /**
     * 删除用户拥有的角色
     *
     * @param userId
     * @return
     */
    boolean removeByUserId(String userId);

    /**
     * 根据userId查询用户拥有角色id集合
     *
     * @param userId
     * @return
     */
    Set<String> queryByUserId(String userId);
}

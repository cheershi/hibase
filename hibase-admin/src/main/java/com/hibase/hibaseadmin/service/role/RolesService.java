package com.hibase.hibaseadmin.service.role;

import com.github.pagehelper.PageInfo;
import com.hibase.hibaseadmin.entity.role.Roles;
import com.hibase.hibaseadmin.entity.role.vo.RolesSearchVO;
import com.hibase.hibaseweb.service.BaseService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
public interface RolesService extends BaseService<Roles> {

    /**
     * 查询角色表列表
     *
     * @param searchVO
     * @return
     */
    PageInfo<Roles> selectRolesList(RolesSearchVO searchVO);

    /**
     * 改变角色表记录
     *
     * @param entity
     * @return
     */
    void saveRoles(Roles entity);

    /**
     * 查询角色表详情
     *
     * @param id
     * @return
     */
    Roles viewRoles(String id);

    /**
     * 删除角色表
     *
     * @param id
     */
    void deleteRoles(String id);
}

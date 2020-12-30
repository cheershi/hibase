package com.hibase.hibaseadmin.service.role.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.hibase.hibaseadmin.entity.role.Roles;
import com.hibase.hibaseadmin.entity.role.vo.RolesSearchVO;
import com.hibase.hibaseadmin.mapper.role.RolesMapper;
import com.hibase.hibaseadmin.service.role.RolesService;
import com.hibase.hibaseweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RolesServiceImpl extends BaseServiceImpl<RolesMapper, Roles> implements RolesService {

    /**
     * 查询角色表列表
     */
    @Override
    public PageInfo<Roles> selectRolesList(RolesSearchVO searchVO) {

        return super.page(searchVO, new QueryWrapper<Roles>());
    }

    /**
     * 改变角色表记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRoles(Roles entity) {

        super.store(entity);
    }

    /**
     * 查询角色表详情
     */
    @Override
    public Roles viewRoles(String id) {

        Roles entity = super.getById(id, true);

        return entity;
    }

    /**
     * 删除角色表记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoles(String id) {

        super.deleteBy(id);
    }
}

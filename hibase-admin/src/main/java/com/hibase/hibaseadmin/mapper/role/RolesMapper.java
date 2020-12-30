package com.hibase.hibaseadmin.mapper.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hibase.hibaseadmin.entity.role.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Repository
@Mapper
public interface RolesMapper extends BaseMapper<Roles> {

}

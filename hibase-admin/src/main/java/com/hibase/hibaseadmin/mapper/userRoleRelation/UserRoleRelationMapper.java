package com.hibase.hibaseadmin.mapper.userRoleRelation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hibase.hibaseadmin.entity.userRoleRelation.UserRoleRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Repository
@Mapper
public interface UserRoleRelationMapper extends BaseMapper<UserRoleRelation> {

}

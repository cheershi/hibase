package com.hibase.hibaseadmin.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hibase.hibaseadmin.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
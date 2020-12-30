package com.hibase.hibaseadmin.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hibase.common.web.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("users")
public class User extends BasePo {

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码密文
     */
    private String password;

    /**
     * 简介
     */
    private String description;

    /**
     * 是否有效用户
     */
    private Boolean enabled;

    /**
     * 账号是否未过期
     */
    private Boolean accountNonExpired;

    /**
     * 密码是否未过期
     */
    private Boolean credentialsNonExpired;

    /**
     * 是否未锁定
     */
    private Boolean accountNonLocked;

    @TableField(exist = false)
    private Set<String> roleIds;
}

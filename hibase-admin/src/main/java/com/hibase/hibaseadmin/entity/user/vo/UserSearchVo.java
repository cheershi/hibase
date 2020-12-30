package com.hibase.hibaseadmin.entity.user.vo;

import cn.hutool.core.bean.BeanUtil;
import com.hibase.common.web.entity.vo.PageBase;
import com.hibase.hibaseadmin.entity.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@ApiModel("查询用户信息")
@Data
public class UserSearchVo extends PageBase {

    UserSearchVo(User user){
        BeanUtil.copyProperties(user,this);
    }

    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String name;

    /**
     * 用户手机
     */
    @ApiModelProperty(value = "用户手机")
    private String mobile;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 用户密码密文
     */
    @ApiModelProperty(value = "用户密码密文")
    private String password;

    /**
     * 简介
     */
    @ApiModelProperty(value = "简介")
    private String description;

    /**
     * 是否有效用户
     */
    @ApiModelProperty(value = "是否有效用户")
    private Boolean enabled;

    /**
     * 账号是否未过期
     */
    @ApiModelProperty(value = "账号是否未过期")
    private Boolean accountNonExpired;

    /**
     * 密码是否未过期
     */
    @ApiModelProperty(value = "密码是否未过期")
    private Boolean credentialsNonExpired;

    /**
     * 是否未锁定
     */
    @ApiModelProperty(value = "是否未锁定")
    private Boolean accountNonLocked;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

    /**
     * 是否已删除 逻辑删除
     */
    @ApiModelProperty(value = "是否已删除 逻辑删除")
    private Boolean beDeleted;

    @ApiModelProperty(value = "角色列表")
    private Set<String> roleIds;
}

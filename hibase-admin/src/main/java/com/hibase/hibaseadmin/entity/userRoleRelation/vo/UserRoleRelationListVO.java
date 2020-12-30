package com.hibase.hibaseadmin.entity.userRoleRelation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 用户和角色关系表
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Data
@ApiModel(value="UserRoleRelationListVO对象", description="用户和角色关系表列表展示VO")
public class UserRoleRelationListVO {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "角色id")
    private String roleId;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;

    @ApiModelProperty(value = "关系id")
    private String id;

    @ApiModelProperty(value = "是否已删除（0 正常，1 已删除）")
    private Boolean beDeleted;


}

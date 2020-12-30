package com.hibase.hibaseadmin.entity.role.vo;

import com.hibase.common.web.entity.vo.PageBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Data
@ApiModel(value="RolesSearchVO对象", description="角色表查询条件VO")
public class RolesSearchVO extends PageBase {

    @ApiModelProperty(value = "角色code")
    private String code;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

    @ApiModelProperty(value = "创建人")
    private String createdBy;

    @ApiModelProperty(value = "更新人")
    private String updatedBy;


}

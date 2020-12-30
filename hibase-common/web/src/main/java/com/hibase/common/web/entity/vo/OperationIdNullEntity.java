package com.hibase.common.web.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author 陈丰
 */
@Data
@ApiModel("操作对象id，id可为空")
public class OperationIdNullEntity {

    @ApiModelProperty(value = "id", example = "123")
    private String id;
}

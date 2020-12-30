package com.hibase.common.web.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author 陈丰
 */
@Data
@ApiModel("操作对象id和分页，ID可为空")
public class OperationIdNullAndPageEntity extends PageBase {

    @ApiModelProperty(value = "id", example = "1232342")
    private String id;
}

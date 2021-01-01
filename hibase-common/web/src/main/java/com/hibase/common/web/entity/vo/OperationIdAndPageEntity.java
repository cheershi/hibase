package com.hibase.common.web.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@ApiModel("操作对象id和分页")
public class OperationIdAndPageEntity extends PageBase {

    @ApiModelProperty(value = "id", example = "1232342")
    @NotBlank(message = "请选择记录")
    private String id;
}

package com.hibase.common.web.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.hibase.common.web.constant.GlobalConstant;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BasePo implements Serializable {
    public final static String DEFAULT_USERNAME = "system";
    @TableId(type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatedTime;

    /**
     * 是否已删除 逻辑删除
     */
    @TableLogic(value = GlobalConstant.BE_DELETE_NO + "", delval = GlobalConstant.BE_DELETE_YES + "")
    private Boolean beDeleted;
}

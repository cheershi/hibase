package com.hibase.hibaseadmin.entity.role;

import com.hibase.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Roles extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 简介
     */
    private String description;

}

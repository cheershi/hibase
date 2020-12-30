package com.hibase.common.web.entity.vo;

import com.hibase.common.web.entity.po.BasePo;
import lombok.Data;

/**
 * 数据权限DO
 *
 * @author chenfeng
 * @date 2019/05/20
 */
@Data
public class BasePermVO extends BasePo {

    /**
     * 所属平台id
     */
    private String platformId;

    /**
     * 所属组织id
     */
    private String orgId;
}

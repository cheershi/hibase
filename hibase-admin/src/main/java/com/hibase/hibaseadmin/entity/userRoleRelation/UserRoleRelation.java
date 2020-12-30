package com.hibase.hibaseadmin.entity.userRoleRelation;

import com.hibase.common.web.entity.po.BasePo;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户和角色关系表
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserRoleRelation extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;


}

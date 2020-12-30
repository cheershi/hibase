package com.hibase.hibaseadmin.web.role;

import com.github.pagehelper.PageInfo;
import com.hibase.common.core.entity.vo.Result;
import com.hibase.common.web.entity.vo.OperationIdEntity;
import com.hibase.hibaseadmin.entity.role.Roles;
import com.hibase.hibaseadmin.entity.role.vo.*;
import com.hibase.hibaseadmin.service.role.RolesService;
import com.hibase.hibaseweb.annotation.web.HibasePostRequestMapping;
import com.hibase.hibaseweb.util.EntityUtil;
import com.hibase.hibaseweb.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/roles")
@Api(tags = "角色表")
@Slf4j
public class RolesController extends BaseController {

    @Autowired
    private RolesService rolesService;

    @ApiOperation(value = "查询角色表列表", httpMethod = "POST")
    @HibasePostRequestMapping(value = "selectRolesList")
    public Result<RolesListVO> selectRolesList(@RequestBody RolesSearchVO searchVO) {

        PageInfo result = rolesService.selectRolesList(searchVO);
        result.setList(EntityUtil.transform(result.getList(), RolesListVO.class));

        return super.successMsg(result);
    }

    @ApiOperation(value = "新增角色表记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "insertRoles")
    public Result<String> insertRoles(@RequestBody RolesInsertVO insertVO) {

        Roles entity = EntityUtil.transform(insertVO, Roles.class);

        rolesService.saveRoles(entity);

        return super.successMsg(entity.getId());
    }

    @ApiOperation(value = "修改角色表记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "updateRoles")
    public Result<String> updateRoles(@RequestBody RolesUpdateVO updateVO) {

        Roles entity = EntityUtil.transform(updateVO, Roles.class);

        rolesService.saveRoles(entity);

        return super.successMsg(entity.getId());
    }

    @ApiOperation(value = "查询角色表详情", httpMethod = "POST")
    @HibasePostRequestMapping(value = "viewRolesDetails")
    public Result<RolesViewVO> viewRolesDetails(@RequestBody OperationIdEntity operationidEntity) {

        return super.successMsg(EntityUtil.transform(rolesService.viewRoles(operationidEntity.getId()), RolesViewVO.class));
    }

    @ApiOperation(value = "删除角色表记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "/deleteRoles")
    public Result<String> deleteRoles(@RequestBody OperationIdEntity delete) {

        rolesService.deleteRoles(delete.getId());

        return super.successMsg();
    }

}

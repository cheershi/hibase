package com.hibase.hibaseadmin.web.userRoleRelation;

import com.github.pagehelper.PageInfo;
import com.hibase.common.core.entity.vo.Result;
import com.hibase.common.web.entity.vo.OperationIdEntity;
import com.hibase.hibaseadmin.entity.userRoleRelation.UserRoleRelation;
import com.hibase.hibaseadmin.entity.userRoleRelation.vo.*;
import com.hibase.hibaseadmin.service.userRoleRelation.UserRoleRelationService;
import com.hibase.hibaseweb.annotation.web.HibasePostRequestMapping;
import com.hibase.hibaseweb.util.EntityUtil;
import com.hibase.hibaseweb.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户和角色关系表 前端控制器
 * </p>
 *
 * @author chenfeng
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/user-role-relation")
@Api(tags = "用户和角色关系表")
public class UserRoleRelationController extends BaseController {

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @ApiOperation(value = "查询用户和角色关系表列表", httpMethod = "POST")
    @HibasePostRequestMapping(value = "selectUserRoleRelationList")
    public Result<UserRoleRelationListVO> selectUserRoleRelationList(@RequestBody UserRoleRelationSearchVO searchVO) {

        PageInfo result = userRoleRelationService.selectUserRoleRelationList(searchVO);

        result.setList(EntityUtil.transform(result.getList(), UserRoleRelationListVO.class));

        return super.successMsg(result);
    }

    @ApiOperation(value = "新增用户和角色关系表记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "insertUserRoleRelation")
    public Result<String> insertUserRoleRelation(@RequestBody UserRoleRelationInsertVO insertVO) {

        UserRoleRelation entity = EntityUtil.transform(insertVO, UserRoleRelation.class);

        userRoleRelationService.saveUserRoleRelation(entity);

        return super.successMsg(entity.getId());
    }

    @ApiOperation(value = "修改用户和角色关系表记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "updateUserRoleRelation")
    public Result<String> updateUserRoleRelation(@RequestBody UserRoleRelationUpdateVO updateVO) {

        UserRoleRelation entity = EntityUtil.transform(updateVO, UserRoleRelation.class);

        userRoleRelationService.saveUserRoleRelation(entity);

        return super.successMsg(entity.getId());
    }

    @ApiOperation(value = "查询用户和角色关系表详情", httpMethod = "POST")
    @HibasePostRequestMapping(value = "viewUserRoleRelationDetails")
    public Result<UserRoleRelationViewVO> viewUserRoleRelationDetails(@RequestBody OperationIdEntity operationidEntity) {

        return super.successMsg(EntityUtil.transform(userRoleRelationService.viewUserRoleRelation(operationidEntity.getId()), UserRoleRelationViewVO.class));
    }

    @ApiOperation(value = "删除用户和角色关系表记录", httpMethod = "POST")
    @HibasePostRequestMapping(value = "/deleteUserRoleRelation")
    public Result<String> deleteUserRoleRelation(@RequestBody OperationIdEntity delete) {

        userRoleRelationService.deleteUserRoleRelation(delete.getId());

        return super.successMsg();
    }
}

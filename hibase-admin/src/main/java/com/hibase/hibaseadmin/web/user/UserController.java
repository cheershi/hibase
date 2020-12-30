package com.hibase.hibaseadmin.web.user;

import cn.hutool.core.bean.BeanUtil;
import com.hibase.common.core.entity.vo.Result;
import com.hibase.hibaseadmin.entity.user.User;
import com.hibase.hibaseadmin.entity.user.vo.UserInsertVo;
import com.hibase.hibaseadmin.entity.user.vo.UserSearchVo;
import com.hibase.hibaseadmin.entity.user.vo.UserUpdateVo;
import com.hibase.hibaseadmin.service.user.UserService;
import com.hibase.hibaseweb.annotation.web.HibaseDeleteRequestMapping;
import com.hibase.hibaseweb.annotation.web.HibaseGetRequestMapping;
import com.hibase.hibaseweb.annotation.web.HibasePostRequestMapping;
import com.hibase.hibaseweb.annotation.web.HibasePutRequestMapping;
import com.hibase.hibaseweb.web.BaseController;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Api("user")
@Slf4j
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户", notes = "新增一个用户")
    @HibasePostRequestMapping
    public Result add(@Valid @RequestBody UserInsertVo insertVo) {
        log.debug("name:{}", insertVo);
        User user = BeanUtil.copyProperties(insertVo, User.class);
        return Result.success(userService.add(user));
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象，逻辑删除")
    @HibaseDeleteRequestMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        return Result.success(userService.delete(id));
    }

    @ApiOperation(value = "修改用户", notes = "修改指定用户信息")
    @HibasePutRequestMapping(value = "/{id}")
    public Result update(@PathVariable String id, @Valid @RequestBody UserUpdateVo userUpdateVo) {
        User user = BeanUtil.copyProperties(userUpdateVo, User.class);
        user.setId(id);
        return Result.success(userService.update(user));
    }

    @ApiOperation(value = "获取用户", notes = "获取指定用户信息")
    @HibaseGetRequestMapping(value = "/{id}")
    public Result get(@PathVariable String id) {
        log.debug("get with id:{}", id);
        return Result.success(userService.get(id));
    }

    @ApiOperation(value = "获取用户", notes = "根据用户唯一标识（username or mobile）获取用户信息")
    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = Result.class))
    @HibaseGetRequestMapping
    public Result query(@RequestParam String uniqueId) {
        log.debug("query with username or mobile:{}", uniqueId);
        return Result.success(userService.getByUniqueId(uniqueId));
    }

    @ApiOperation(value = "搜索用户", notes = "根据条件查询用户信息")
    @HibasePostRequestMapping(value = "/conditions")
    public Result search(@Valid @RequestBody UserSearchVo searchVo) {
        log.debug("search with userQueryForm:{}", searchVo);
        return Result.success(userService.query(searchVo));
    }
}

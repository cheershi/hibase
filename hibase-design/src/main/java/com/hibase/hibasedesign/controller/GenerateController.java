package com.hibase.hibasedesign.controller;


import com.hibase.common.core.entity.vo.Result;
import com.hibase.hibasedesign.config.GenerateCode;
import com.hibase.hibasedesign.config.GenerateProperties;
import com.hibase.hibaseweb.annotation.web.HibasePostRequestMapping;
import com.hibase.hibaseweb.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动生成代码
 *
 * @author hufeng
 * @date 2019/03/21
 */
@Api(tags = "自动生成代码")
@RestController
@RequestMapping("generate")
@Slf4j
public class GenerateController extends BaseController {

    @ApiOperation(value = "自动生成代码", httpMethod = "POST")
    @HibasePostRequestMapping(value = "generateCode")
    public Result generateCode(@RequestBody GenerateProperties properties) {
        GenerateCode.generateCode(properties);
        return super.successMsg();
    }
}

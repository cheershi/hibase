package com.hibase.common.core.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hibase.common.core.exception.SystemErrorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
public class Result<T> {

    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MESG = "处理成功";

    public static final String FAIL_CODE = "999999";
    public static final String FAIL_MESG = "系统异常";

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;

    @ApiModelProperty(value = "处理结果描述信息")
    private String mesg;

    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant time;

    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Result() {
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     */
//    public Result(ErrorType errorType) {
//        this.code = errorType.getCode();
//        this.mesg = errorType.getMessage();
//        this.time = ZonedDateTime.now().toInstant();
//    }

    /**
     * @param errorType
     * @param data
     */
//    public Result(ErrorType errorType, T data) {
//        this(errorType);
//        this.data = data;
//    }

    /**
     *
     *
     * @param code
     * @param mesg
     * @param data
     */
    public Result(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
        this.time = ZonedDateTime.now().toInstant();
    }

    public Result(T data) {
        this(SUCCESSFUL_CODE,SUCCESSFUL_MESG);
        this.data = data;
    }

    /**
     *
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    /**
     *
     *
     * @return Result
     */
    public static Result success() {
        return success(null);
    }

    /**
     *
     *
     * @return Result
     */
    public static Result fail() {
        return new Result(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     *
     *
     * @param baseException
     * @return Result
     */
//    public static Result fail(HibaseException baseException) {
//        return fail(baseException, null);
//    }

    /**
     *
     *
     * @param data
     * @return Result
     */
//    public static Result fail(HibaseException baseException, Object data) {
//        return new Result<>(baseException.getErrorType(), data);
//    }

    /**
     *
     *
     * @param errorType
     * @param data
     * @return Result
     */
//    public static Result fail(ErrorType errorType, Object data) {
//        return new Result<>(errorType, data);
//    }

    /**
     *
     *
     * @param errorType
     * @return Result
     */
//    public static Result fail(ErrorType errorType) {
//        return Result.fail(errorType, null);
//    }

    /**
     *
     *
     * @param data
     * @return Result
     */
//    public static Result fail(Object data) {
//        return new Result<>(SystemErrorType.DEFAULT_EXCEPTION, data);
//    }


    /**
     *
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     *
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}

package com.hibase.common.web.exception;


import com.hibase.common.core.entity.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * todo 暂时没有用到全局异常处理
 * @author 陈丰
 */
@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

//    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
//    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex) {
//        log.error("missing servlet request parameter exception:{}", ex.getMessage());
//        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
//    }
//
//    @ExceptionHandler(value = {MultipartException.class})
//    public Result uploadFileLimitException(MultipartException ex) {
//        log.error("upload file size limit:{}", ex.getMessage());
//        return Result.fail(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT);
//    }
//
//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    public Result serviceException(MethodArgumentNotValidException ex) {
//        log.error("service exception:{}", ex.getMessage());
//        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult().getFieldError().getDefaultMessage());
//    }
//
//    @ExceptionHandler(value = {DuplicateKeyException.class})
//    public Result duplicateKeyException(DuplicateKeyException ex) {
//        log.error("primary key duplication exception:{}", ex.getMessage());
//        return Result.fail(SystemErrorType.DUPLICATE_PRIMARY_KEY);
//    }
//
//    @ExceptionHandler(value = {HibaseException.class})
//    public Result baseException(HibaseException ex) {
//        log.error("base exception:{}", ex.getMessage());
//        return Result.fail(ex.getMessage());
//    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception() {
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable() {
        return Result.fail();
    }
}
package com.hibase.common.core.exception;

import lombok.Getter;

/**
 * @author 陈丰
 */
@Getter
public class HibaseException extends RuntimeException {
    /**
     * 异常对应的错误类型
     */
    private ErrorType errorType;

    /**
     * 状态码
     */
    protected String code = SystemErrorType.DEFAULT_EXCEPTION.getCode();

    /**
     * 默认
     */
    public HibaseException() {
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public HibaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public HibaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public HibaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }


    public HibaseException(String message) {
        super(message);
    }

    public HibaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public HibaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public HibaseException(String code , String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public HibaseException(Throwable cause) {
        super(cause);
    }

    public HibaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

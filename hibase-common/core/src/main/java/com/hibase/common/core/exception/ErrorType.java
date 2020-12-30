package com.hibase.common.core.exception;

/**
 * 错误类型
 * @author 陈丰
 */
public interface ErrorType {
    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMessage();
}

package com.guyi.project.common.exception;

import com.guyi.project.common.response.ReturnCode;

/**
 * 业务异常类
 *
 * @author 孤诣
 */
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(ReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
    }

    public BusinessException(ReturnCode returnCode, String message) {
        super(message);
        this.code = returnCode.getCode();
    }

    public int getCode() {
        return code;
    }
}

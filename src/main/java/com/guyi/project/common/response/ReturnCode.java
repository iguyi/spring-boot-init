package com.guyi.project.common.response;

/**
 * 返回状态码
 *
 * @author 孤诣
 */
public enum ReturnCode {
    /**
     * 成功的返回码枚举值
     */
    OK(0, "成功"),

    /**
     * 请求参数问题的返回码枚举值
     */
    PARAMS_ERROR(40000, "请求参数错误"),

    /**
     * 权限问题的返回码枚举值
     */
    NOT_LOGIN_ERROR(40100, "未登录"),
    NO_AUTH_ERROR(40101, "无权限"),

    /**
     * 系统内部问题
     */
    SYSTEM_ERROR(50000, "系统内部异常"),
    DB_SAVE_ERROR(50001, "数据保存失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 默认描述
     */
    private final String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

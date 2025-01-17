package com.guyi.project.common.response;

/**
 * 返回工具类
 *
 * @author 孤诣
 */
public class ResultUtil {
    /**
     * 请求处理成功
     *
     * @param data 返回的数据
     * @param <T>  返回数据的类型
     * @return 响应对象
     */
    public static <T> BaseResponse<T> ok(T data) {
        ReturnCode success = ReturnCode.OK;
        return new BaseResponse<>(success.getCode(), data, success.getMessage());
    }

    public static <T> BaseResponse<T> error(int returnCode, String message) {
        return new BaseResponse<>(returnCode, null, message);
    }

    public static <T> BaseResponse<T> error(ReturnCode returnCode, String message) {
        return new BaseResponse<>(returnCode.getCode(), null, message);
    }

    public static <T> BaseResponse<T> error(ReturnCode returnCode) {
        return new BaseResponse<>(returnCode.getCode(), null, returnCode.getMessage());
    }
}

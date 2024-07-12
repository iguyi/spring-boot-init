package com.guyi.project.common.constant;

/**
 * 用户相关常量
 *
 * @author 孤诣
 */
public interface UserConstant {
    // region 账号相关

    /**
     * 用户账号的最小长度
     */
    int USER_ACCOUNT_MIN_LENGTH = 4;

    /**
     * 用户账号的最大长度
     */
    int USER_ACCOUNT_MAX_LENGTH = 18;

    /**
     * 用户账号的规则: <br/>
     * - 长度在 [4, 18] 之间 <br/>
     * - 只能包含数字、字母、下划线
     */
    String USER_ACCOUNT_RULE = String.format("^[0-9a-zA-Z_]{%s,%s}", USER_ACCOUNT_MIN_LENGTH, USER_ACCOUNT_MAX_LENGTH);

    // endregion

    // region 密码相关

    /**
     * 用户账号的密码最小长度
     */
    int USER_PASSWORD_MIN_LENGTH = 8;

    /**
     * 用户账号的密码最小长度
     */
    int USER_PASSWORD_MAX_LENGTH = 32;

    /**
     * 用户密码的规则: <br/>
     * - 长度在 [8, 32] 之间 <br/>
     * - 可以包含: 数字、字母、`~·!@$%^&*()_-+=[]{}|\:;"'><,.?/
     */
    String USER_PASSWORD_RULE = "^[0-9a-zA-Z!@#$%^&*()\\-_=+|\\\\:;\\\"'<>,~·`.?/\\{\\[\\}\\]]{"
            + USER_PASSWORD_MIN_LENGTH + "," + USER_PASSWORD_MAX_LENGTH + "}$";

    // endregion

    /**
     * 用户登录态属性 key
     */
    String USER_LOGIN_STATE = "userLoginState";
}

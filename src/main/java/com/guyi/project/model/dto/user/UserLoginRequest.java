package com.guyi.project.model.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录请求参数的封装
 *
 * @author 孤诣
 */
@Data
public class UserLoginRequest {
    /**
     * 账号
     */
    @ApiModelProperty(value = "用户账号")
    private String userAccount;

    /**
     * 密码
     */
    @ApiModelProperty(value = "用户账号的密码")
    private String userPassword;

    private static final long serialVersionUID = 1L;
}

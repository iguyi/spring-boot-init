package com.guyi.project.controller;

import com.guyi.project.common.response.BaseResponse;
import com.guyi.project.common.response.ResultUtil;
import com.guyi.project.model.dto.user.UserRegisterRequest;
import com.guyi.project.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.guyi.project.common.response.ReturnCode.SYSTEM_ERROR;

/**
 * User 请求控制器
 *
 * @author 孤诣
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    // region 登录相关

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public BaseResponse<Boolean> register(@RequestBody UserRegisterRequest registerRequest) {
        Boolean result = userService.register(registerRequest);
        if (result != null && result) {
            return ResultUtil.ok(true);
        }
        return ResultUtil.error(SYSTEM_ERROR);
    }

    // endregion
}

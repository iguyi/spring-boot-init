package com.guyi.project.controller;

import com.guyi.project.common.response.BaseResponse;
import com.guyi.project.common.response.ResultUtil;
import com.guyi.project.model.dto.user.UserLoginRequest;
import com.guyi.project.model.dto.user.UserRegisterRequest;
import com.guyi.project.model.vo.user.UserVO;
import com.guyi.project.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.guyi.project.common.constant.UserConstant.USER_LOGIN_STATE;
import static com.guyi.project.common.response.ReturnCode.*;

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

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public BaseResponse<UserVO> login(@RequestBody UserLoginRequest loginRequest, HttpServletRequest request) {
        UserVO loginState = userService.login(loginRequest);
        if (loginState == null) {
            return ResultUtil.error(PARAMS_ERROR, "账号或密码错误");
        }
        request.setAttribute(USER_LOGIN_STATE, loginRequest);
        return ResultUtil.ok(loginState);
    }

    @PostMapping("/current/state")
    @ApiOperation("获取当前用户登录态")
    public BaseResponse<UserVO> getCurrent(HttpServletRequest request) {
        Object attribute = request.getAttribute(USER_LOGIN_STATE);
        if (attribute == null) {
            return ResultUtil.error(NOT_LOGIN_ERROR);
        }
        return ResultUtil.ok((UserVO) attribute);
    }

    // endregion
}

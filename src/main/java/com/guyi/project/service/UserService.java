package com.guyi.project.service;

import com.guyi.project.model.dto.user.UserLoginRequest;
import com.guyi.project.model.dto.user.UserRegisterRequest;
import com.guyi.project.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guyi.project.model.vo.user.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 针对表【user(用户)】的数据库操作 Service
 *
 * @author 孤诣
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册请求
     *
     * @param registerRequest 用户注册请求参数
     * @return 如果返回值为 true, 则注册成功
     */
    Boolean register(UserRegisterRequest registerRequest);

    /**
     * 用户登录
     *
     * @param loginRequest 用户登录请求参数
     * @return 用户登录态
     */
    UserVO login(UserLoginRequest loginRequest);
}

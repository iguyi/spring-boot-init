package com.guyi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guyi.project.common.constant.ProjectProperties;
import com.guyi.project.common.exception.BusinessException;
import com.guyi.project.common.util.StringCheckUtil;
import com.guyi.project.mapper.UserMapper;
import com.guyi.project.model.dto.user.UserRegisterRequest;
import com.guyi.project.model.entity.User;
import com.guyi.project.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

import static com.guyi.project.common.constant.UserConstant.USER_ACCOUNT_RULE;
import static com.guyi.project.common.constant.UserConstant.USER_PASSWORD_RULE;
import static com.guyi.project.common.response.ReturnCode.DB_SAVE_ERROR;
import static com.guyi.project.common.response.ReturnCode.PARAMS_ERROR;

/**
 * 针对表【user(用户)】的数据库操作 Service 实现
 *
 * @author 孤诣
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private ProjectProperties projectProperties;

    @Override
    public Boolean register(UserRegisterRequest registerRequest) {
        // 参数校验
        if (registerRequest == null) {
            throw new BusinessException(PARAMS_ERROR);
        }
        // 账号校验
        String userAccount = registerRequest.getUserAccount();
        if (StringUtils.isBlank(userAccount) || StringCheckUtil.notIsRegex(userAccount, USER_ACCOUNT_RULE)) {
            throw new BusinessException(PARAMS_ERROR, "账号格式有误");
        }
        // 密码校验
        String userPassword = registerRequest.getUserPassword();
        if (StringUtils.isBlank(userPassword) || StringCheckUtil.notIsRegex(userPassword, USER_PASSWORD_RULE)) {
            throw new BusinessException(PARAMS_ERROR, "密码格式错误");
        }
        if (!userPassword.equals(registerRequest.getCheckPassword())) {
            throw new BusinessException(PARAMS_ERROR, "密码输入不一致");
        }

        // 保存数据
        User user = new User();
        BeanUtils.copyProperties(registerRequest, user);
        // 设置加密后的密码
        user.setUserPassword(encryptUserPassword(userPassword));
        if (this.save(user)) {
            return true;
        }
        throw new BusinessException(DB_SAVE_ERROR);
    }

    /**
     * 加密密码
     */
    private String encryptUserPassword(String password) {
        return DigestUtils.md5DigestAsHex((projectProperties.getSalt() + password).getBytes());
    }
}





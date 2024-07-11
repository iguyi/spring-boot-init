package com.guyi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guyi.project.model.entity.User;
import com.guyi.project.service.UserService;
import com.guyi.project.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 针对表【user(用户)】的数据库操作 Service 实现
 *
 * @author 孤诣
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}





package com.huawei.progress.biz.common.service.impl;

import com.huawei.progress.biz.model.UserModel;
import com.huawei.progress.biz.common.mapper.UserMapper;
import com.huawei.progress.biz.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserMapper userMapper;
        @Override
        public UserModel loginIn(String name, String password) {
            return userMapper.getInfo(name,password);
        }
}

package com.huawei.progress.service.impl;

import com.huawei.progress.bean.UserBean;
import com.huawei.progress.mapper.UserMapper;
import com.huawei.progress.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resources;

@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserMapper userMapper;
        @Override
        public UserBean loginIn(String name, String password) {
            return userMapper.getInfo(name,password);
        }
}

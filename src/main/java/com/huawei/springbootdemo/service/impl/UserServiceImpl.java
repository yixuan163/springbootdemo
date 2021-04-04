package com.huawei.springbootdemo.service.impl;

import com.huawei.springbootdemo.bean.UserBean;
import com.huawei.springbootdemo.mapper.UserMapper;
import com.huawei.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
        //将DAO注入Service层
        @Autowired
        private UserMapper userMapper;

        @Override
        public UserBean loginIn(String name, String password) {
            return userMapper.getInfo(name,password);
        }
}

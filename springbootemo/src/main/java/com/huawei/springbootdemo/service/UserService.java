package com.huawei.springbootdemo.service;

import com.huawei.springbootdemo.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name, String password);
}

package com.huawei.springbootdemo.mapper;

import com.huawei.springbootdemo.bean.UserBean;

public interface UserMapper {

    UserBean getInfo(String name, String password);

}

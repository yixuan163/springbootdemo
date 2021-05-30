package com.huawei.progress.service;

import com.huawei.progress.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name, String password);
}

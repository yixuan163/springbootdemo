package com.huawei.progress.biz.common.service;

import com.huawei.progress.biz.model.UserModel;

public interface UserService {

    UserModel loginIn(String name, String password);
}

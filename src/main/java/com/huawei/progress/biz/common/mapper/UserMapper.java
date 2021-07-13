package com.huawei.progress.biz.common.mapper;

import com.huawei.progress.biz.model.UserModel;

public interface UserMapper {

    UserModel getInfo(String name, String password);

}

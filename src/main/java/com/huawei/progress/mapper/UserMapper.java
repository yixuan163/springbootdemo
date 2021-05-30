package com.huawei.progress.mapper;

import com.huawei.progress.bean.UserBean;

public interface UserMapper {

    UserBean getInfo(String name, String password);

}

package com.huawei.test;

import com.huawei.springbootdemo.bean.UserBean;
import com.huawei.springbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
        @Autowired
        UserService userService;

        @Test
        public void contextLoads() {
            UserBean userBean = userService.loginIn("a","a");
            System.out.println("该用户ID为：");
            System.out.println(userBean.getId());
        }
}

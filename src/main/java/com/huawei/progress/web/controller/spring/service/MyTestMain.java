package com.huawei.progress.web.controller.spring.service;

import com.huawei.progress.biz.spring.service.impl.FunctionServiceImpl;
import com.huawei.progress.biz.spring.service.impl.UserFunctionServiceImpl;
import com.huawei.progress.common.config.DiConfig;
import com.huawei.progress.common.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTestMain {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(DiConfig.class);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        UserFunctionServiceImpl functionService = context.getBean(UserFunctionServiceImpl.class);

        System.out.println(functionService.sayHello("测试配置类0"));
        context.close();
    }
}

package com.huawei.progress.common.config;

import com.huawei.progress.biz.spring.service.impl.FunctionServiceImpl;
import com.huawei.progress.biz.spring.service.impl.UserFunctionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public UserFunctionServiceImpl userFunctionServiceImpl(){
        return new UserFunctionServiceImpl();
    }
}

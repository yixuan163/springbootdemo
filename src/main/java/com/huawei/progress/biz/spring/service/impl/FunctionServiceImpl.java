package com.huawei.progress.biz.spring.service.impl;

import com.huawei.progress.biz.spring.service.FunctionService;
import org.springframework.stereotype.Service;

//@Service
public class FunctionServiceImpl implements FunctionService {
    public String sayHello(String word){
        return "Hello "+ word +" !";
    }
}

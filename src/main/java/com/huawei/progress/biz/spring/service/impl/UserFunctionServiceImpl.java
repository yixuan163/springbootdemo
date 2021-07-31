package com.huawei.progress.biz.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserFunctionServiceImpl {

//      @Autowired
      FunctionServiceImpl functionServiceImpl = new FunctionServiceImpl();


    public String sayHello(String word) {
        return functionServiceImpl.sayHello(word);
    }
}

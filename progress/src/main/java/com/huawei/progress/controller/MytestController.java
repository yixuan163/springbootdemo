package com.huawei.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MytestController {

    @RequestMapping("/index")
    public String show() {
            return "index";
    }


}

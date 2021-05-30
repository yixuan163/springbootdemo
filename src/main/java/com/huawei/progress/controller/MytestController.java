package com.huawei.progress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MytestController {

    @RequestMapping("/index")
    public String show() {
            return "success";
    }
}

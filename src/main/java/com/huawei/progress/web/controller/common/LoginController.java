package com.huawei.progress.web.controller.common;

import com.huawei.progress.biz.model.UserModel;
import com.huawei.progress.biz.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name,String password){
        UserModel userModel = userService.loginIn(name,password);
        if(userModel !=null){
            return "success";
        }else {
            return "error";
        }
    }
}

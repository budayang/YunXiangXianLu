package org.yunxiangxianlu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.UserBiz;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @PostMapping("/login")
    public String login() {
        userBiz.login();
        return "login";
    }
}

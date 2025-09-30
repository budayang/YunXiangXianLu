package org.yunxiangxianlu.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.biz.UserBiz;
import org.yunxiangxianlu.service.UserService;

@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserService userService;

    @Override
    public void login() {
        userService.login();
    }
}

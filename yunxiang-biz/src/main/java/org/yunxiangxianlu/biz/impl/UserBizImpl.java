package org.yunxiangxianlu.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.biz.UserBiz;
import org.yunxiangxianlu.common.util.DateUtils;
import org.yunxiangxianlu.dal.entity.UserDO;
import org.yunxiangxianlu.service.UserService;

@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserService userService;

    @Override
    public Boolean existsByUsername(String username) {
        return userService.existsByUsername(username);
    }

    @Override
    public void save(String username, String password) {
        UserDO userDO = UserDO.builder()
                .username(username)
                .password(password)
                .status(0)
                .creater(1L)
                .updater(1L)
                .created(DateUtils.getCurrentTimestamp())
                .updated(DateUtils.getCurrentTimestamp())
                .build();
        userService.saveUser(userDO);
    }

    @Override
    public UserDO findByUsername(String username) {
        return userService.findByUsername(username);
    }
}

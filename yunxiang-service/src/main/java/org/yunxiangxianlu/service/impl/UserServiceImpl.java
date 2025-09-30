package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.UserDao;
import org.yunxiangxianlu.dal.entity.UserDO;
import org.yunxiangxianlu.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void login() {

    }
}

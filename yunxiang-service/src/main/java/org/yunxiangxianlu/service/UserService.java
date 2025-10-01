package org.yunxiangxianlu.service;

import org.yunxiangxianlu.dal.entity.UserDO;

public interface UserService {

    Boolean existsByUsername(String username);

    void saveUser(UserDO  user);

    UserDO findByUsername(String username);
}

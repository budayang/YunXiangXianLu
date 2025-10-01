package org.yunxiangxianlu.biz;

import org.yunxiangxianlu.dal.entity.UserDO;

public interface UserBiz {

    Boolean existsByUsername(String username);

    void save(String username, String password);

    UserDO findByUsername(String username);
}

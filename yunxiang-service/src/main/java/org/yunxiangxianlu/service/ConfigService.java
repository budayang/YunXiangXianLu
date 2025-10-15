package org.yunxiangxianlu.service;

import org.yunxiangxianlu.dal.entity.ConfigDO;

import java.util.List;

public interface ConfigService {

    void addConfig(ConfigDO req);

    void updateConfig(ConfigDO req);

    List<ConfigDO> listConfig(ConfigDO req);
}

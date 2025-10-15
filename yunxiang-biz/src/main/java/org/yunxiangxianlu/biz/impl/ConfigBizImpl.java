package org.yunxiangxianlu.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.yunxiangxianlu.biz.ConfigBiz;
import org.yunxiangxianlu.common.dto.req.config.ConfigAddReq;
import org.yunxiangxianlu.common.dto.req.config.ConfigListReq;
import org.yunxiangxianlu.common.dto.req.config.ConfigUpdateReq;
import org.yunxiangxianlu.common.dto.res.config.ConfigListVO;
import org.yunxiangxianlu.dal.entity.ConfigDO;
import org.yunxiangxianlu.service.ConfigService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ConfigBizImpl implements ConfigBiz {

    @Autowired
    private ConfigService configService;

    @Override
    public void addConfig(ConfigAddReq req) {
        ConfigDO configDO = ConfigDO.builder()
                .configType(req.getConfigType())
                .configKey(req.getConfigKey())
                .configValue(req.getConfigValue()).build();
        configService.addConfig(configDO);
    }

    @Override
    public void updateConfig(ConfigUpdateReq req) {
        ConfigDO configDO = ConfigDO.builder()
                .id(req.getId())
                .configValue(req.getConfigValue())
                .build();
        configService.updateConfig(configDO);
    }

    @Override
    public List<ConfigListVO> listConfig(ConfigListReq req) {
        ConfigDO configDO = ConfigDO.builder()
                .configKey(req.getConfigKey())
                .build();
        List<ConfigDO> configDOS = configService.listConfig(configDO);
        if (CollectionUtils.isEmpty(configDOS)) {
            return Collections.emptyList();
        }
        List<ConfigListVO> configListVOS = new ArrayList<>();
        for (ConfigDO aDo : configDOS) {
            ConfigListVO configListVO = ConfigListVO.builder()
                    .id(aDo.getId())
                    .configKey(aDo.getConfigKey())
                    .configValue(aDo.getConfigValue())
                    .build();
            configListVOS.add(configListVO);
        }
        return configListVOS;
    }
}

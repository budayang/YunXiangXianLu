package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.yunxiangxianlu.dal.dao.ConfigDAO;
import org.yunxiangxianlu.dal.entity.ConfigDO;
import org.yunxiangxianlu.service.ConfigService;

import java.util.List;

@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigDAO, ConfigDO> implements ConfigService {

    @Override
    public void addConfig(ConfigDO req) {
        this.baseMapper.insert(req);
    }

    @Override
    public void updateConfig(ConfigDO req) {
        UpdateWrapper<ConfigDO> configDOUpdateWrapper = new UpdateWrapper<>();
        configDOUpdateWrapper.eq("id", req.getId());
        if (StringUtils.hasText(req.getConfigValue())) {
            configDOUpdateWrapper.set("config_value", req.getConfigValue());
        } else {
            return;
        }
        this.update(configDOUpdateWrapper);
    }

    @Override
    public List<ConfigDO> listConfig(ConfigDO req) {
        QueryWrapper<ConfigDO> configDOQueryWrapper = new QueryWrapper<>();
        if (req.getConfigType() != null) {
            configDOQueryWrapper.eq("config_type", req.getConfigType());
        }
        if (req.getConfigKey() != null) {
            configDOQueryWrapper.eq("config_key", req.getConfigKey());
        }
        return this.list(configDOQueryWrapper);
    }
}

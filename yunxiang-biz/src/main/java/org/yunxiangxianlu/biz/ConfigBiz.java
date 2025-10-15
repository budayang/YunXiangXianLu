package org.yunxiangxianlu.biz;

import org.yunxiangxianlu.common.dto.req.config.ConfigAddReq;
import org.yunxiangxianlu.common.dto.req.config.ConfigListReq;
import org.yunxiangxianlu.common.dto.req.config.ConfigUpdateReq;
import org.yunxiangxianlu.common.dto.res.config.ConfigListVO;

import java.util.List;

public interface ConfigBiz {

    void addConfig(ConfigAddReq req);

    void updateConfig(ConfigUpdateReq req);

    List<ConfigListVO> listConfig(ConfigListReq req);
}

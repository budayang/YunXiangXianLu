package org.yunxiangxianlu.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.ConfigBiz;
import org.yunxiangxianlu.common.dto.req.config.ConfigAddReq;
import org.yunxiangxianlu.common.dto.req.config.ConfigListReq;
import org.yunxiangxianlu.common.dto.req.config.ConfigUpdateReq;
import org.yunxiangxianlu.common.dto.res.Result;
import org.yunxiangxianlu.common.dto.res.config.ConfigListVO;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/config")
@RestController
public class ConfigController {

    @Autowired
    private ConfigBiz configBiz;

    @PostMapping("/add")
    public Result<Void> add(@RequestBody @Valid ConfigAddReq req) {
        configBiz.addConfig(req);
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody @Valid ConfigUpdateReq req) {
        configBiz.updateConfig(req);
        return Result.success();
    }

    @PostMapping("/list")
    public Result<List<ConfigListVO>> list(@RequestBody @Valid ConfigListReq req) {
        return Result.success(configBiz.listConfig(req));
    }
}

package org.yunxiangxianlu.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.MemberBiz;
import org.yunxiangxianlu.common.dto.req.member.MemberAddReq;
import org.yunxiangxianlu.common.dto.req.member.MemberListReq;
import org.yunxiangxianlu.common.dto.req.member.MemberUpdateReq;
import org.yunxiangxianlu.common.dto.res.Result;
import org.yunxiangxianlu.common.dto.res.member.MemberVO;

import javax.validation.Valid;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberBiz memberBiz;

    @PostMapping("/add")
    public Result<Void> add(@RequestBody @Valid MemberAddReq req) {
        return Result.success();
    }

    @PostMapping("/update")
    public Result<Void> update(@RequestBody @Valid MemberUpdateReq req) {
        return Result.success();
    }

    @PostMapping("/list")
    public Result<Page<MemberVO>> list(@RequestBody @Valid MemberListReq req) {
        return Result.success();
    }
}

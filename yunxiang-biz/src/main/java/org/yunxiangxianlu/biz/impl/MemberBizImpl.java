package org.yunxiangxianlu.biz.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.biz.MemberBiz;
import org.yunxiangxianlu.common.dto.req.member.MemberAddReq;
import org.yunxiangxianlu.common.dto.req.member.MemberListReq;
import org.yunxiangxianlu.common.dto.req.member.MemberUpdateReq;
import org.yunxiangxianlu.common.dto.res.member.MemberVO;

@Service
public class MemberBizImpl implements MemberBiz {
    @Override
    public void addMember(MemberAddReq req) {
        // 1、插入会员主表
        // 2、插入会员钱包表（需要根据配置，发放余额和广告券）
        // 3、插入用户表
        // 4、插入推荐人

    }

    @Override
    public void updateMember(MemberUpdateReq req) {

    }

    @Override
    public Page<MemberVO> listMember(MemberListReq req) {
        return null;
    }
}

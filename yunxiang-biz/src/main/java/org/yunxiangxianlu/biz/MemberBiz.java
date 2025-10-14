package org.yunxiangxianlu.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.yunxiangxianlu.common.dto.req.member.MemberAddReq;
import org.yunxiangxianlu.common.dto.req.member.MemberListReq;
import org.yunxiangxianlu.common.dto.req.member.MemberUpdateReq;
import org.yunxiangxianlu.common.dto.res.member.MemberVO;

public interface MemberBiz {

    void addMember(MemberAddReq req);

    void updateMember(MemberUpdateReq req);

    Page<MemberVO> listMember(MemberListReq req);
}

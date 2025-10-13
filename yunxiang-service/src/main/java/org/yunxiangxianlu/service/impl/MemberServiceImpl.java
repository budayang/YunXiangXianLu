package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.MemberDAO;
import org.yunxiangxianlu.dal.entity.MemberDO;
import org.yunxiangxianlu.service.MemberService;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberDAO, MemberDO> implements MemberService {
}

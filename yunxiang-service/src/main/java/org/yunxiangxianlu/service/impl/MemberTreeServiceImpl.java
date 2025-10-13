package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.MemberTreeDAO;
import org.yunxiangxianlu.dal.entity.MemberTreeDO;
import org.yunxiangxianlu.service.MemberTreeService;

@Service
public class MemberTreeServiceImpl extends ServiceImpl<MemberTreeDAO, MemberTreeDO> implements MemberTreeService {
}

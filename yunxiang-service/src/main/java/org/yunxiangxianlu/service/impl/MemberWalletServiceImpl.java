package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.MemberWalletDAO;
import org.yunxiangxianlu.dal.entity.MemberWalletDO;
import org.yunxiangxianlu.service.MemberWalletService;

@Service
public class MemberWalletServiceImpl extends ServiceImpl<MemberWalletDAO, MemberWalletDO> implements MemberWalletService {
}

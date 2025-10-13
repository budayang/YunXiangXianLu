package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.WalletTransactionDAO;
import org.yunxiangxianlu.dal.entity.WalletTransactionDO;
import org.yunxiangxianlu.service.WalletTransactionService;

@Service
public class WalletTransactionServiceImpl extends ServiceImpl<WalletTransactionDAO, WalletTransactionDO> implements WalletTransactionService {
}

package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.PerformanceDAO;
import org.yunxiangxianlu.dal.entity.PerformanceDO;
import org.yunxiangxianlu.service.PerformanceService;

@Service
public class PerformanceServiceImpl extends ServiceImpl<PerformanceDAO, PerformanceDO> implements PerformanceService {
}

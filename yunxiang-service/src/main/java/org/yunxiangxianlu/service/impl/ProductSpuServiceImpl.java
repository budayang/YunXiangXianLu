package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.ProductSpuDAO;
import org.yunxiangxianlu.dal.entity.ProductSpuDO;
import org.yunxiangxianlu.service.ProductSpuService;

@Service
public class ProductSpuServiceImpl extends ServiceImpl<ProductSpuDAO, ProductSpuDO> implements ProductSpuService {
}

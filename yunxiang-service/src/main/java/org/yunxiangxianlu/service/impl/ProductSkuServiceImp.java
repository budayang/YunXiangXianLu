package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.ProductSkuDAO;
import org.yunxiangxianlu.dal.entity.ProductSkuDO;
import org.yunxiangxianlu.service.ProductSkuService;

@Service
public class ProductSkuServiceImp extends ServiceImpl<ProductSkuDAO, ProductSkuDO> implements ProductSkuService {
}

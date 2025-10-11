package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.ProductSpecificationDAO;
import org.yunxiangxianlu.dal.entity.ProductSpecificationDO;
import org.yunxiangxianlu.service.ProductSpecificationService;

@Service
public class ProductSpecificationServiceImpl extends ServiceImpl<ProductSpecificationDAO, ProductSpecificationDO> implements ProductSpecificationService {
}

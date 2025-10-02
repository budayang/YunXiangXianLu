package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.dal.dao.ProductCategoryDAO;
import org.yunxiangxianlu.dal.entity.ProductCategoryDO;
import org.yunxiangxianlu.service.ProductCategoryService;

import java.util.List;

@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryDAO, ProductCategoryDO> implements ProductCategoryService {

    @Override
    public List<ProductCategoryDO> productCategoryList() {
        return this.list();
    }
}

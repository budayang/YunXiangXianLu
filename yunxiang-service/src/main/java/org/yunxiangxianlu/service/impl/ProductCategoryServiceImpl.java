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

    @Override
    public void addProductCategory(ProductCategoryDO productCategoryDO) {
        this.save(productCategoryDO);
    }

    @Override
    public void updateProductCategory(ProductCategoryDO productCategoryDO) {
        this.updateById(productCategoryDO);
    }

    @Override
    public void deleteProductCategory(Long id) {
        this.removeById(id);
    }
}

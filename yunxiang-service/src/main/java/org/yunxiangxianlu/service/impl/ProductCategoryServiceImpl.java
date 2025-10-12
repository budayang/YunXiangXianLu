package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.yunxiangxianlu.dal.dao.ProductCategoryDAO;
import org.yunxiangxianlu.dal.entity.ProductCategoryDO;
import org.yunxiangxianlu.service.ProductCategoryService;

import java.util.List;
import java.util.Set;

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
        UpdateWrapper<ProductCategoryDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", productCategoryDO.getId());
        if (StringUtils.hasText(productCategoryDO.getCategoryName())) {
            updateWrapper.set("category_name", productCategoryDO.getCategoryName());
        }
        if (productCategoryDO.getSortOrder() != null) {
            updateWrapper.set("sort_order", productCategoryDO.getSortOrder());
        }
        if (StringUtils.hasText(productCategoryDO.getImageUrl())) {
            updateWrapper.set("image_url", productCategoryDO.getImageUrl());
        }
        updateWrapper.set("updated", productCategoryDO.getUpdated());
        updateWrapper.set("updater", productCategoryDO.getUpdater());
        this.update(updateWrapper);
    }

    @Override
    public void deleteProductCategory(Long id) {
        this.removeById(id);
    }

    @Override
    public List<ProductCategoryDO> listProductCategory(Set<Long> ids) {
        QueryWrapper<ProductCategoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids);
        return this.list(queryWrapper);
    }
}

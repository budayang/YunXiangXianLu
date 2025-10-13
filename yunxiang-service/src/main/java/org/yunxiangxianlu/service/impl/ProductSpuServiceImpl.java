package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.yunxiangxianlu.dal.dao.ProductSpuDAO;
import org.yunxiangxianlu.dal.entity.ProductSpuDO;
import org.yunxiangxianlu.service.ProductSpuService;

@Service
public class ProductSpuServiceImpl extends ServiceImpl<ProductSpuDAO, ProductSpuDO> implements ProductSpuService {
    @Override
    public void addProductSpu(ProductSpuDO productSpuDO) {
        this.save(productSpuDO);
    }

    @Override
    public void updateProductSpu(ProductSpuDO productSpuDO) {
        UpdateWrapper<ProductSpuDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", productSpuDO.getId());
        if (StringUtils.hasText(productSpuDO.getName())) {
            updateWrapper.set("name", productSpuDO.getName());
        }
        if (productSpuDO.getCategoryId() != null) {
            updateWrapper.set("category_id", productSpuDO.getCategoryId());
        }
        if (StringUtils.hasText(productSpuDO.getBrand())) {
            updateWrapper.set("brand", productSpuDO.getBrand());
        }
        if (StringUtils.hasText(productSpuDO.getDescription())) {
            updateWrapper.set("description", productSpuDO.getDescription());
        }
        if (productSpuDO.getStatus() != null) {
            updateWrapper.set("status", productSpuDO.getStatus());
        }
        if (StringUtils.hasText(productSpuDO.getImageUrl())) {
            updateWrapper.set("image_url", productSpuDO.getImageUrl());
        }
        this.update(updateWrapper);
    }

    @Override
    public void deleteProductSpu(Long id) {
        this.removeById(id);
    }

    @Override
    public IPage<ProductSpuDO> listProductSpu(Page<ProductSpuDO> page, QueryWrapper<ProductSpuDO> queryWrapper) {
        // 执行分页查询
        return this.page(page, queryWrapper);
    }
}

package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.yunxiangxianlu.dal.dao.ProductSkuDAO;
import org.yunxiangxianlu.dal.entity.ProductSkuDO;
import org.yunxiangxianlu.service.ProductSkuService;

import java.util.List;

@Service
public class ProductSkuServiceImp extends ServiceImpl<ProductSkuDAO, ProductSkuDO> implements ProductSkuService {
    @Override
    public void addProductSku(List<ProductSkuDO> productSkuDOs) {
        this.saveBatch(productSkuDOs);
    }

    @Override
    public void updateProductSku(ProductSkuDO productSkuDO) {
        UpdateWrapper<ProductSkuDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", productSkuDO.getId());
        if (CollectionUtils.isEmpty(productSkuDO.getSpecifications())) {
            updateWrapper.set("specifications", productSkuDO.getSpecifications());
        }
        if (productSkuDO.getPrice() != null) {
            updateWrapper.set("price", productSkuDO.getPrice());
        }
        if (productSkuDO.getCostPrice() != null) {
            updateWrapper.set("cost_price", productSkuDO.getCostPrice());
        }
        if (productSkuDO.getStock() != null) {
            updateWrapper.set("stock", productSkuDO.getStock());
        }
        if (productSkuDO.getWeight() != null) {
            updateWrapper.set("weight", productSkuDO.getWeight());
        }
        if (productSkuDO.getImageUrl() != null) {
            updateWrapper.set("image_url", productSkuDO.getImageUrl());
        }
        if (productSkuDO.getStatus() != null) {
            updateWrapper.set("status", productSkuDO.getStatus());
        }
        this.update(updateWrapper);
    }
}

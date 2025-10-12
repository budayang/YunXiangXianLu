package org.yunxiangxianlu.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.yunxiangxianlu.dal.dao.ProductSpecificationDAO;
import org.yunxiangxianlu.dal.entity.ProductSpecificationDO;
import org.yunxiangxianlu.service.ProductSpecificationService;

import java.util.List;

@Service
public class ProductSpecificationServiceImpl extends ServiceImpl<ProductSpecificationDAO, ProductSpecificationDO> implements ProductSpecificationService {

    @Override
    public void addProductSpecification(List<ProductSpecificationDO> productSpecificationDOs) {
        this.saveBatch(productSpecificationDOs);
    }

    @Override
    public void updateProductSpecification(ProductSpecificationDO productSpecificationDO) {
        UpdateWrapper<ProductSpecificationDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", productSpecificationDO.getId());
        if (StringUtils.hasText(productSpecificationDO.getSpecName())) {
            updateWrapper.set("spec_name", productSpecificationDO.getSpecName());
        }
        if (StringUtils.hasText(productSpecificationDO.getSpecValue())) {
            updateWrapper.set("spec_value", productSpecificationDO.getSpecValue());
        }
        if (productSpecificationDO.getSortOrder() != null) {
            updateWrapper.set("sort_order", productSpecificationDO.getSortOrder());
        }
        this.update(updateWrapper);
    }

    @Override
    public void deleteProductSpecification(ProductSpecificationDO productSpecificationDO) {
        if (productSpecificationDO.getId() != null) {
            this.removeById(productSpecificationDO.getId());
        }
        if (productSpecificationDO.getSpuId() != null) {
            this.remove(new UpdateWrapper<ProductSpecificationDO>().eq("spu_id", productSpecificationDO.getSpuId()));
        }
    }
}

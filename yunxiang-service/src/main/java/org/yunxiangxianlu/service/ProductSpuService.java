package org.yunxiangxianlu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.yunxiangxianlu.dal.entity.ProductSpuDO;

public interface ProductSpuService {

    void addProductSpu(ProductSpuDO productSpuDO);

    void updateProductSpu(ProductSpuDO productSpuDO);

    IPage<ProductSpuDO> listProductSpu(Page<ProductSpuDO> page, QueryWrapper<ProductSpuDO> queryWrapper);
}

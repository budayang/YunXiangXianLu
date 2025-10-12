package org.yunxiangxianlu.service;

import org.yunxiangxianlu.dal.entity.ProductSkuDO;

import java.util.List;

public interface ProductSkuService {

    void addProductSku(List<ProductSkuDO> productSkuDOs);

    void updateProductSku(ProductSkuDO productSkuDO);

    void deleteProductSku(ProductSkuDO productSkuDO);

    List<ProductSkuDO> listProductSku(ProductSkuDO productSkuDO);
}

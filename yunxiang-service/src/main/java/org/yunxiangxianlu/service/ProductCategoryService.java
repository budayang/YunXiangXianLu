package org.yunxiangxianlu.service;

import org.yunxiangxianlu.dal.entity.ProductCategoryDO;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryDO> productCategoryList();

    void addProductCategory(ProductCategoryDO productCategoryDO);

    void updateProductCategory(ProductCategoryDO productCategoryDO);

    void deleteProductCategory(Long id);
}

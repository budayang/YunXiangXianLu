package org.yunxiangxianlu.service;

import org.yunxiangxianlu.dal.entity.ProductCategoryDO;

import java.util.List;
import java.util.Set;

public interface ProductCategoryService {

    List<ProductCategoryDO> productCategoryList();

    void addProductCategory(ProductCategoryDO productCategoryDO);

    void updateProductCategory(ProductCategoryDO productCategoryDO);

    void deleteProductCategory(Long id);

    List<ProductCategoryDO> listProductCategory(Set<Long> ids);
}

package org.yunxiangxianlu.service;

import org.yunxiangxianlu.dal.entity.ProductSpecificationDO;

import java.util.List;

public interface ProductSpecificationService {

    void addProductSpecification(List<ProductSpecificationDO> productSpecificationDOs);

    void  updateProductSpecification(ProductSpecificationDO productSpecificationDO);

    void deleteProductSpecification(ProductSpecificationDO productSpecificationDO);

    List<ProductSpecificationDO> listProductSpecification(ProductSpecificationDO productSpecificationDO);
}

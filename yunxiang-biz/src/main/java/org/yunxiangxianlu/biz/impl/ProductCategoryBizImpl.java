package org.yunxiangxianlu.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.yunxiangxianlu.biz.ProductCategoryBiz;
import org.yunxiangxianlu.common.dto.res.ProductCategoryVO;
import org.yunxiangxianlu.dal.entity.ProductCategoryDO;
import org.yunxiangxianlu.service.ProductCategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryBizImpl implements ProductCategoryBiz {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public List<ProductCategoryVO> list() {
        List<ProductCategoryDO> productCategoryDOS = productCategoryService.productCategoryList();
        if (CollectionUtils.isEmpty(productCategoryDOS)) {
            return new ArrayList<>();
        }
        List<ProductCategoryVO> productCategoryVOS = new ArrayList<>();
        for (ProductCategoryDO productCategoryDO : productCategoryDOS) {
            ProductCategoryVO productCategoryVO = ProductCategoryVO.builder()
                    .categoryName(productCategoryDO.getCategoryName())
                    .sortOrder(productCategoryDO.getSortOrder())
                    .imageUrl(productCategoryDO.getImageUrl())
                    .build();
            productCategoryVOS.add(productCategoryVO);
        }
        return productCategoryVOS;
    }
}

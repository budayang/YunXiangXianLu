package org.yunxiangxianlu.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yunxiangxianlu.biz.ProductCategoryBiz;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryAddReqDTO;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryDeleteReqDTO;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryUpdateReqDTO;
import org.yunxiangxianlu.common.dto.res.ProductCategoryVO;
import org.yunxiangxianlu.common.util.DateUtils;
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
                    .id(productCategoryDO.getId())
                    .categoryName(productCategoryDO.getCategoryName())
                    .sortOrder(productCategoryDO.getSortOrder())
                    .imageUrl(productCategoryDO.getImageUrl())
                    .build();
            productCategoryVOS.add(productCategoryVO);
        }
        return productCategoryVOS;
    }

    @Override
    public void add(ProductCategoryAddReqDTO reqDTO) {
        ProductCategoryDO productCategoryDO = ProductCategoryDO.builder()
                .categoryName(reqDTO.getCategoryName())
                .sortOrder(reqDTO.getSortOrder())
                .imageUrl(reqDTO.getImageUrl())
                .created(DateUtils.getCurrentTimestamp())
                .updated(DateUtils.getCurrentTimestamp())
                .creater(1L)
                .updater(1L)
                .build();
        productCategoryService.addProductCategory(productCategoryDO);
    }

    @Override
    public void update(ProductCategoryUpdateReqDTO reqDTO) {
        ProductCategoryDO productCategoryDO = ProductCategoryDO.builder()
                .id(reqDTO.getId())
                .categoryName(reqDTO.getCategoryName())
                .sortOrder(reqDTO.getSortOrder())
                .imageUrl(reqDTO.getImageUrl())
                .updated(DateUtils.getCurrentTimestamp())
                .updater(1L)
                .build();
        productCategoryService.updateProductCategory(productCategoryDO);
    }

    @Override
    public void delete(ProductCategoryDeleteReqDTO reqDTO) {
        productCategoryService.deleteProductCategory(reqDTO.getId());
    }
}

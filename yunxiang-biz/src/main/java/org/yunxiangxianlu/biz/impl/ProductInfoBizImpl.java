package org.yunxiangxianlu.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yunxiangxianlu.biz.ProductInfoBiz;
import org.yunxiangxianlu.common.dto.req.productInfo.*;
import org.yunxiangxianlu.dal.entity.ProductSkuDO;
import org.yunxiangxianlu.dal.entity.ProductSpecificationDO;
import org.yunxiangxianlu.dal.entity.ProductSpuDO;
import org.yunxiangxianlu.service.ProductSkuService;
import org.yunxiangxianlu.service.ProductSpecificationService;
import org.yunxiangxianlu.service.ProductSpuService;

import java.util.*;

@Service
public class ProductInfoBizImpl implements ProductInfoBiz {

    @Autowired
    private ProductSpuService productSpuService;

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @Autowired
    private ProductSkuService productSkuService;

    @Override
    public void addProductSpu(SpuAddReq req) {
        ProductSpuDO productSpuDO = ProductSpuDO.builder()
                .name(req.getName())
                .categoryId(req.getCategoryId())
                .brand(req.getBrand())
                .description(req.getDescription())
                .status(req.getStatus())
                .build();
        productSpuService.addProductSpu(productSpuDO);
    }

    @Override
    public void updateProductSpu(SpuUpdateReq req) {
        ProductSpuDO productSpuDO = ProductSpuDO.builder()
                .id(req.getId())
                .name(req.getName())
                .categoryId(req.getCategoryId())
                .brand(req.getBrand())
                .description(req.getDescription())
                .status(req.getStatus())
                .build();
        productSpuService.updateProductSpu(productSpuDO);
    }

    @Override
    public void addProductSpecification(SpecificationAddReq req) {
        List<ProductSpecificationDO> productSpecificationDOList = new ArrayList<>();
        for (SpecificationAddReq.SpecificationInfo specificationInfo : req.getSpecificationInfoList()) {
            ProductSpecificationDO productSpecificationDO = ProductSpecificationDO.builder()
                    .spuId(req.getSpuId())
                    .specName(specificationInfo.getSpecName())
                    .specValue(specificationInfo.getSpecValue())
                    .sortOrder(specificationInfo.getSortOrder())
                    .build();
            productSpecificationDOList.add(productSpecificationDO);
        }
        productSpecificationService.addProductSpecification(productSpecificationDOList);
    }

    @Override
    public void updateProductSpecification(SpecificationUpdateReq req) {
        ProductSpecificationDO productSpecificationDO = ProductSpecificationDO.builder()
                .id(req.getId())
                .specName(req.getSpecName())
                .specValue(req.getSpecValue())
                .sortOrder(req.getSortOrder())
                .build();
        productSpecificationService.updateProductSpecification(productSpecificationDO);
    }

    @Override
    public void addProductSku(SkuAddReq req) {
        List<ProductSkuDO> productSkuDOList = new ArrayList<>();
        for (SkuAddReq.SkuInfo skuInfo : req.getSkuInfoList()) {
            Map<String, String> map = new HashMap<>();
            for (SpecificationUpdateReq specificationInfo : skuInfo.getSpecificationList()) {
                map.put(specificationInfo.getSpecName(), specificationInfo.getSpecValue());
            }
            ProductSkuDO productSkuDO = ProductSkuDO.builder()
                    .spuId(req.getSpuId())
                    .skuCode(UUID.randomUUID().toString())
                    .specifications(map)
                    .price(skuInfo.getPrice())
                    .costPrice(skuInfo.getCostPrice())
                    .stock(skuInfo.getStock())
                    .weight(skuInfo.getWeight())
                    .imageUrl(skuInfo.getImageUrl())
                    .status(skuInfo.getStatus())
                    .build();
            productSkuDOList.add(productSkuDO);
        }
        productSkuService.addProductSku(productSkuDOList);
    }

    @Override
    public void updateProductSku(SkuUpdateReq req) {
        ProductSkuDO productSkuDO = ProductSkuDO.builder()
                .id(req.getId())
                .price(req.getPrice())
                .costPrice(req.getCostPrice())
                .stock(req.getStock())
                .weight(req.getWeight())
                .imageUrl(req.getImageUrl())
                .status(req.getStatus())
                .build();
        productSkuService.updateProductSku(productSkuDO);
    }
}

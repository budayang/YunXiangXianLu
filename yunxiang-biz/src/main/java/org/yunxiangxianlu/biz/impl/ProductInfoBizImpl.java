package org.yunxiangxianlu.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yunxiangxianlu.biz.ProductInfoBiz;
import org.yunxiangxianlu.common.dto.req.productInfo.*;
import org.yunxiangxianlu.common.dto.res.productInfo.SpuVO;
import org.yunxiangxianlu.dal.entity.ProductCategoryDO;
import org.yunxiangxianlu.dal.entity.ProductSkuDO;
import org.yunxiangxianlu.dal.entity.ProductSpecificationDO;
import org.yunxiangxianlu.dal.entity.ProductSpuDO;
import org.yunxiangxianlu.service.ProductCategoryService;
import org.yunxiangxianlu.service.ProductSkuService;
import org.yunxiangxianlu.service.ProductSpecificationService;
import org.yunxiangxianlu.service.ProductSpuService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductInfoBizImpl implements ProductInfoBiz {

    @Autowired
    private ProductSpuService productSpuService;

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private ProductCategoryService productCategoryService;

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
    @Transactional(rollbackFor = Exception.class)
    public void deleteProductSpu(SpuDeleteReq req) {
        productSpuService.deleteProductSpu(req.getId());
        productSpecificationService.deleteProductSpecification(ProductSpecificationDO.builder().spuId(req.getId()).build());
        productSkuService.deleteProductSku(ProductSkuDO.builder().spuId(req.getId()).build());
    }

    @Override
    public Page<SpuVO> pageSpu(SpuListReq req) {
        // 创建分页对象
        Page<ProductSpuDO> page = new Page<>(req.getPageNum(), req.getPageSize());
        // 构建查询条件
        QueryWrapper<ProductSpuDO> queryWrapper = new QueryWrapper<>();
        if (StringUtils.hasText(req.getName())) {
            queryWrapper.like("name", req.getName());
        }
        // 执行分页查询
        IPage<ProductSpuDO> userPage = productSpuService.listProductSpu(page, queryWrapper);
        Page<SpuVO> resultPage = new Page<>();
        if (CollectionUtils.isEmpty(userPage.getRecords())) {
            resultPage.setRecords(new ArrayList<>());
        } else {
            Set<Long> categoryIds = userPage.getRecords().stream().map(ProductSpuDO::getCategoryId).collect(Collectors.toSet());
            // 查询分类名称
            List<ProductCategoryDO> productSpecificationDOList = productCategoryService.listProductCategory(categoryIds);
            Map<Long, String> categoryNameMap = productSpecificationDOList.stream().collect(Collectors.toMap(ProductCategoryDO::getId, ProductCategoryDO::getCategoryName));
            List<SpuVO> spuVOList = new ArrayList<>();
            for (ProductSpuDO record : userPage.getRecords()) {
                SpuVO spuVO = SpuVO.builder()
                        .id(record.getId())
                        .name(record.getName())
                        .categoryName(categoryNameMap.get(record.getCategoryId()))
                        .brand(record.getBrand())
                        .description(record.getDescription())
                        .status(record.getStatus())
                        .build();
                spuVOList.add(spuVO);
            }
            resultPage.setRecords(spuVOList);
        }
        resultPage.setCurrent(userPage.getCurrent());
        resultPage.setSize(userPage.getSize());
        resultPage.setTotal(userPage.getTotal());
        resultPage.setPages(userPage.getPages());
        return resultPage;
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
    public void deleteProductSpecification(SpecificationDeleteReq req) {
        productSpecificationService.deleteProductSpecification(ProductSpecificationDO.builder().id(req.getId()).build());
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

    @Override
    public void deleteProductSku(SkuDeleteReq req) {
        productSkuService.deleteProductSku(ProductSkuDO.builder().id(req.getId()).build());
    }
}

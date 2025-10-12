package org.yunxiangxianlu.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.ProductInfoBiz;
import org.yunxiangxianlu.common.dto.req.productInfo.*;
import org.yunxiangxianlu.common.dto.res.Result;
import org.yunxiangxianlu.common.dto.res.productInfo.SpuVO;

import javax.validation.Valid;

@RequestMapping("/product-info")
@RestController
public class ProductInfoController {

    @Autowired
    private ProductInfoBiz productInfoBiz;

    @PostMapping("/product-spu/add")
    public Result<Void> addProductSpu(@RequestBody @Valid SpuAddReq req) {
        productInfoBiz.addProductSpu(req);
        return Result.success();
    }

    @PostMapping("/product-spu/update")
    public Result<Void> updateProductSpu(@RequestBody @Valid SpuUpdateReq req) {
        productInfoBiz.updateProductSpu(req);
        return Result.success();
    }

    @PostMapping("/product-spu/delete")
    public Result<Void> deleteProductSpu(@RequestBody @Valid SpuDeleteReq req) {
        productInfoBiz.deleteProductSpu(req);
        return Result.success();
    }

    @PostMapping("/product-spu/list")
    public Result<Page<SpuVO>> listProductSpu(@RequestBody @Valid SpuListReq req) {
        Page<SpuVO> page = productInfoBiz.pageSpu(req);
        return Result.success(page);
    }

    @PostMapping("/product-specification/add")
    public Result<Void> addProductSpecification(@RequestBody @Valid SpecificationAddReq req) {
        productInfoBiz.addProductSpecification(req);
        return Result.success();
    }

    @PostMapping("/product-specification/update")
    public Result<Void> updateProductSpecification(@RequestBody @Valid SpecificationUpdateReq req) {
        productInfoBiz.updateProductSpecification(req);
        return Result.success();
    }

    @PostMapping("/product-specification/delete")
    public Result<Void> deleteProductSpecification(@RequestBody @Valid SpecificationDeleteReq req) {
        productInfoBiz.deleteProductSpecification(req);
        return Result.success();
    }

    @PostMapping("/product-specification/list")
    public Result<Void> listProductSpecification() {
        return Result.success();
    }

    @PostMapping("/product-sku/add")
    public Result<Void> addProductSku(@RequestBody @Valid SkuAddReq req) {
        productInfoBiz.addProductSku(req);
        return Result.success();
    }

    @PostMapping("/product-sku/update")
    public Result<Void> updateProductSku(@RequestBody @Valid SkuUpdateReq req) {
        productInfoBiz.updateProductSku(req);
        return Result.success();
    }

    @PostMapping("/product-sku/delete")
    public Result<Void> deleteProductSku(@RequestBody @Valid SkuDeleteReq req) {
        productInfoBiz.deleteProductSku(req);
        return Result.success();
    }

    @PostMapping("/product-sku/list")
    public Result<Void> listProductSku() {
        return Result.success();
    }
}

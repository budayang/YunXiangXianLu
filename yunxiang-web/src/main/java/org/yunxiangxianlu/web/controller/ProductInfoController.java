package org.yunxiangxianlu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.ProductInfoBiz;
import org.yunxiangxianlu.common.dto.req.productInfo.*;
import org.yunxiangxianlu.common.dto.res.Result;

import javax.validation.Valid;

@RequestMapping("/product-info")
@RestController
public class ProductInfoController {

    @Autowired
    private ProductInfoBiz productInfoBiz;

    @PostMapping("/add-product-spu")
    public Result<Void> addProductSpu(@RequestBody @Valid SpuAddReq req) {
        productInfoBiz.addProductSpu(req);
        return Result.success();
    }

    @PostMapping("/update-product-spu")
    public Result<Void> updateProductSpu(@RequestBody @Valid SpuUpdateReq req) {
        productInfoBiz.updateProductSpu(req);
        return Result.success();
    }

    @PostMapping("/delete-product-spu")
    public Result<Void> deleteProductSpu() {
        return Result.success();
    }

    @PostMapping("/list-product-spu")
    public Result<Void> listProductSpu() {
        return Result.success();
    }

    @PostMapping("/add-product-specification")
    public Result<Void> addProductSpecification(@RequestBody @Valid SpecificationAddReq req) {
        productInfoBiz.addProductSpecification(req);
        return Result.success();
    }

    @PostMapping("/update-product-specification")
    public Result<Void> updateProductSpecification(@RequestBody @Valid SpecificationUpdateReq req) {
        productInfoBiz.updateProductSpecification(req);
        return Result.success();
    }

    @PostMapping("/delete-product-specification")
    public Result<Void> deleteProductSpecification() {
        return Result.success();
    }

    @PostMapping("/list-product-specification")
    public Result<Void> listProductSpecification() {
        return Result.success();
    }

    @PostMapping("/add-product-sku")
    public Result<Void> addProductSku(@RequestBody @Valid SkuAddReq req) {
        productInfoBiz.addProductSku(req);
        return Result.success();
    }

    @PostMapping("/update-product-sku")
    public Result<Void> updateProductSku(@RequestBody @Valid SkuUpdateReq req) {
        productInfoBiz.updateProductSku(req);
        return Result.success();
    }

    @PostMapping("/delete-product-sku")
    public Result<Void> deleteProductSku() {
        return Result.success();
    }

    @PostMapping("/list-product-sku")
    public Result<Void> listProductSku() {
        return Result.success();
    }
}

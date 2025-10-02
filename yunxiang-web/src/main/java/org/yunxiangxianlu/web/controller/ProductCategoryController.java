package org.yunxiangxianlu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.ProductCategoryBiz;
import org.yunxiangxianlu.common.dto.res.ProductCategoryVO;
import org.yunxiangxianlu.common.dto.res.Result;

import java.util.List;

@RequestMapping("/product-category")
@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryBiz productCategoryBiz;

    @RequestMapping("/list")
    public Result<List<ProductCategoryVO>> list() {
        return Result.success(productCategoryBiz.list());
    }
}

package org.yunxiangxianlu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.ProductCategoryBiz;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryAddReqDTO;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryDeleteReqDTO;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryUpdateReqDTO;
import org.yunxiangxianlu.common.dto.res.productCategory.ProductCategoryVO;
import org.yunxiangxianlu.common.dto.res.Result;

import javax.validation.Valid;
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

    @RequestMapping("/add")
    public Result<Void> add(@RequestBody @Valid ProductCategoryAddReqDTO reqDTO) {
        productCategoryBiz.add(reqDTO);
        return Result.success();
    }

    @RequestMapping("/update")
    public Result<Void> update(@RequestBody @Valid ProductCategoryUpdateReqDTO reqDTO) {
        productCategoryBiz.update(reqDTO);
        return Result.success();
    }

    @RequestMapping("/delete")
    public Result<Void> delete(@RequestBody @Valid ProductCategoryDeleteReqDTO reqDTO) {
        productCategoryBiz.delete(reqDTO);
        return Result.success();
    }
}

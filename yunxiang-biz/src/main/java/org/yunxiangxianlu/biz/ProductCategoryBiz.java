package org.yunxiangxianlu.biz;

import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryAddReqDTO;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryDeleteReqDTO;
import org.yunxiangxianlu.common.dto.req.productCategory.ProductCategoryUpdateReqDTO;
import org.yunxiangxianlu.common.dto.res.productCategory.ProductCategoryVO;

import java.util.List;

public interface ProductCategoryBiz {

    List<ProductCategoryVO> list();

    void add(ProductCategoryAddReqDTO reqDTO);

    void update(ProductCategoryUpdateReqDTO reqDTO);

    void delete(ProductCategoryDeleteReqDTO reqDTO);
}

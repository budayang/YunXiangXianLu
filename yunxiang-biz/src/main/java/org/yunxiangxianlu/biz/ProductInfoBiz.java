package org.yunxiangxianlu.biz;

import org.yunxiangxianlu.common.dto.req.productInfo.*;

public interface ProductInfoBiz {

    void addProductSpu(SpuAddReq req);

    void updateProductSpu(SpuUpdateReq req);

    void addProductSpecification(SpecificationAddReq  req);

    void updateProductSpecification(SpecificationUpdateReq req);

    void addProductSku(SkuAddReq req);

    void updateProductSku(SkuUpdateReq req);
}

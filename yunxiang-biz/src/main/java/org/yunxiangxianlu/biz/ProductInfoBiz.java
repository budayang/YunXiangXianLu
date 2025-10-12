package org.yunxiangxianlu.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.yunxiangxianlu.common.dto.req.productInfo.*;
import org.yunxiangxianlu.common.dto.res.productInfo.SpuVO;

public interface ProductInfoBiz {

    void addProductSpu(SpuAddReq req);

    void updateProductSpu(SpuUpdateReq req);

    Page<SpuVO> pageSpu(SpuListReq req);

    void addProductSpecification(SpecificationAddReq  req);

    void updateProductSpecification(SpecificationUpdateReq req);

    void addProductSku(SkuAddReq req);

    void updateProductSku(SkuUpdateReq req);
}

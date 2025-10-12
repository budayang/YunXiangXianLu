package org.yunxiangxianlu.biz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.yunxiangxianlu.common.dto.req.productInfo.*;
import org.yunxiangxianlu.common.dto.res.productInfo.SkuVO;
import org.yunxiangxianlu.common.dto.res.productInfo.SpecificationVO;
import org.yunxiangxianlu.common.dto.res.productInfo.SpuVO;

import java.util.List;

public interface ProductInfoBiz {

    void addProductSpu(SpuAddReq req);

    void updateProductSpu(SpuUpdateReq req);

    void deleteProductSpu(SpuDeleteReq req);

    Page<SpuVO> pageSpu(SpuListReq req);

    void addProductSpecification(SpecificationAddReq  req);

    void updateProductSpecification(SpecificationUpdateReq req);

    void deleteProductSpecification(SpecificationDeleteReq req);

    List<SpecificationVO> listProductSpecification(SpecificationListReq req);

    void addProductSku(SkuAddReq req);

    void updateProductSku(SkuUpdateReq req);

    void deleteProductSku(SkuDeleteReq req);

    List<SkuVO> listProductSku(SkuListReq req);
}

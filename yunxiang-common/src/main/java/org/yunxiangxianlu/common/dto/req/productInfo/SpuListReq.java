package org.yunxiangxianlu.common.dto.req.productInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.yunxiangxianlu.common.dto.req.PageReq;

@EqualsAndHashCode(callSuper = true)
@Data
public class SpuListReq extends PageReq {

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品分类id
     */
    private Long categoryId;
}

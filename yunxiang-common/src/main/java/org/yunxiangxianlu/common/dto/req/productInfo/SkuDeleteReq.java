package org.yunxiangxianlu.common.dto.req.productInfo;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SkuDeleteReq {

    /**
     * id
     */
    @NotNull(message = "skuId不能为空")
    private Long id;
}

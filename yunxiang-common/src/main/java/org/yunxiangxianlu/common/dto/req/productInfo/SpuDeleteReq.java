package org.yunxiangxianlu.common.dto.req.productInfo;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SpuDeleteReq {

    /**
     * 主键
     */
    @NotNull(message = "spuId不能为空")
    private Long id;
}

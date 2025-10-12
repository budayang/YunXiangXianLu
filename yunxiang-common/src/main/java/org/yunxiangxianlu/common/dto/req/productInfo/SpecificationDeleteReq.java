package org.yunxiangxianlu.common.dto.req.productInfo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SpecificationDeleteReq {

    /**
     * 规格ID
     */
    @NotNull(message = "规格ID不能为空")
    private Long id;
}

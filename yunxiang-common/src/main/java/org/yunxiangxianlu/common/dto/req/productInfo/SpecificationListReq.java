package org.yunxiangxianlu.common.dto.req.productInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationListReq {

    /**
     * spuId
     */
    @NotNull(message = "spuId不能为空")
    private Long spuId;
}

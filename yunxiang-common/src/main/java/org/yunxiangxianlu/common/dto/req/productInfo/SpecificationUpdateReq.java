package org.yunxiangxianlu.common.dto.req.productInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationUpdateReq {

    /**
     * 主键
     */
    @NotNull(message = "规格id不能为空")
    private Long id;

    /**
     * 规格名，如：容量、瓶数、包装
     */
    private String specName;

    /**
     * 规格值，如：50ml、12瓶、礼盒装
     */
    private String specValue;

    /**
     * 排序
     */
    private Integer sortOrder;
}

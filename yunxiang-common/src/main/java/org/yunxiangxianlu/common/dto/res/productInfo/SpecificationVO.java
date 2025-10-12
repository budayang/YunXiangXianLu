package org.yunxiangxianlu.common.dto.res.productInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 关联SPU
     */
    private Long spuId;

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

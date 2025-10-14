package org.yunxiangxianlu.common.dto.res.productInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuVO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 关联SPU
     */
    private Long spuId;

    /**
     * SKU编码，可自动生成
     */
    private String skuCode;

    /**
     * 规格组合（JSON格式，如：{"容量":"50ml","瓶数":"12瓶","包装":"3盒装"}）
     * 在Java中通常用 Map<String, String> 表示
     */
    private List<SpecificationVO> specificationList;

    /**
     * 销售价格（元）
     */
    private BigDecimal price;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 重量（kg）
     */
    private BigDecimal weight;

    /**
     * SKU主图
     */
    private String imageUrl;

    /**
     * 状态：1-可售，0-缺货/停售
     */
    private Integer status;
}

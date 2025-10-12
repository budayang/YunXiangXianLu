package org.yunxiangxianlu.common.dto.req.productInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuUpdateReq {

    /**
     * 主键
     */
    @NotNull(message = "skuId不能为空")
    private Long id;

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

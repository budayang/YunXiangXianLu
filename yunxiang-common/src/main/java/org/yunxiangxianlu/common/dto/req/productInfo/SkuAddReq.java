package org.yunxiangxianlu.common.dto.req.productInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuAddReq {

    /**
     * spuId
     */
    @NotNull(message = "spuId不能为空")
    private Long spuId;

    /**
     * sku信息
     */
    @NotEmpty(message = "sku信息不能为空")
    List<SkuInfo> skuInfoList;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SkuInfo {

        /**
         * 规格
         */
        @NotEmpty(message = "规格不能为空")
        private List<SpecificationUpdateReq> specificationList;

        /**
         * 价格
         */
        @NotNull(message = "价格不能为空")
        private BigDecimal price;

        /**
         * 成本价
         */
        private BigDecimal costPrice;

        /**
         * 库存
         */
        @NotNull(message = "库存不能为空")
        private Integer stock;

        /**
         * 状态：1-上架，0-下架
         */
        @NotNull(message = "状态不能为空")
        private Integer status;

        /**
         * 重量
         */
        private BigDecimal weight;

        /**
         * 图片
         */
        private String imageUrl;
    }
}

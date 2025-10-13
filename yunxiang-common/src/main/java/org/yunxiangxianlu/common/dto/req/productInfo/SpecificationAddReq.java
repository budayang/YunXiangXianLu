package org.yunxiangxianlu.common.dto.req.productInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationAddReq {

    /**
     * spuId
     */
    @NotNull(message = "spuId不能为空")
    private Long spuId;

    /**
     * 规格信息
     */
    @NotEmpty(message = "规格信息不能为空")
    private List<SpecificationInfo> specificationInfoList;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpecificationInfo {

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
}

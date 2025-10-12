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
public class SpuUpdateReq {

    /**
     * 主键
     */
    @NotNull(message = "spuId不能为空")
    private Long id;

    /**
     * 产品名称，如：XX品牌洗发水
     */
    private String name;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 状态：1-上架，0-下架
     */
    private Integer status;
}

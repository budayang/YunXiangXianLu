package org.yunxiangxianlu.common.dto.req.productInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpuAddReq {

    /**
     * 产品名称，如：XX品牌洗发水
     */
    @NotBlank(message = "产品名称不能为空")
    private String name;

    /**
     * 分类ID
     */
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;

    /**
     * 品牌
     */
    @NotBlank(message = "品牌不能为空")
    private String brand;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 状态：1-上架，0-下架
     */
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 图片 URL
     */
    private String imageUrl;
}

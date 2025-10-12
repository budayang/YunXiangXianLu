package org.yunxiangxianlu.common.dto.res.productInfo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpuVO {

    /**
     * spuId
     */
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
     * 分类名称
     */
    private String categoryName;

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

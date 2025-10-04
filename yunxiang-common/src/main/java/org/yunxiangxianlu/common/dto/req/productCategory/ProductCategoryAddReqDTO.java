package org.yunxiangxianlu.common.dto.req.productCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryAddReqDTO {

    /**
     * 产品分类名称（如：电子产品、服装）
     */
    private String categoryName;

    /**
     * 展示顺序（数字越小越靠前）
     * 默认值为0
     */
    private Integer sortOrder;

    /**
     * 分类图片URL
     */
    private String imageUrl;
}

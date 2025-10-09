package org.yunxiangxianlu.common.dto.req.productCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryAddReqDTO {

    /**
     * 产品分类名称（如：电子产品、服装）
     */
    @NotEmpty(message = "产品分类名称不能为空")
    private String categoryName;

    /**
     * 展示顺序（数字越小越靠前）
     * 默认值为0
     */
    @NotNull(message = "展示顺序不能为空")
    private Integer sortOrder;

    /**
     * 分类图片URL
     */
    @NotEmpty(message = "分类图片URL不能为空")
    private String imageUrl;
}

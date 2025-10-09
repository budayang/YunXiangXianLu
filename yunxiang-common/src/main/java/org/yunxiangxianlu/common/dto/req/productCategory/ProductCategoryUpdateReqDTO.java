package org.yunxiangxianlu.common.dto.req.productCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryUpdateReqDTO {

    /**
     * id
     */
    @NotNull(message = "id不能为空")
    private Long id;

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

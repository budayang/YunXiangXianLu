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
public class ProductCategoryDeleteReqDTO {

    /**
     * id
     */
    @NotNull(message = "id不能为空")
    private Long id;
}

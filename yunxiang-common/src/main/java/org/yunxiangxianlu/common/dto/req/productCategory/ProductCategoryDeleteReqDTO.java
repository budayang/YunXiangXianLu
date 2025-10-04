package org.yunxiangxianlu.common.dto.req.productCategory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDeleteReqDTO {

    /**
     * id
     */
    private Long id;
}

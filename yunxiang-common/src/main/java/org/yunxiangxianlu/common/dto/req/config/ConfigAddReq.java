package org.yunxiangxianlu.common.dto.req.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigAddReq {

    /**
     * 配置类别
     */
    private Integer configType;

    /**
     * 1:成为会员消费券比例，2:报单使用消费券比例，3:分红静态比例，4:直推奖比例，5:间推奖比例，6:提现配置
     */
    @NotEmpty(message = "配置名称不能为空")
    private Integer configKey;

    /**
     * 配置值
     */
    @NotEmpty(message = "配置值不能为空")
    private String configValue;
}

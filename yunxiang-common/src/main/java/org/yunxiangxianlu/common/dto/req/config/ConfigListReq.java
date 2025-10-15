package org.yunxiangxianlu.common.dto.req.config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfigListReq {

    /**
     * 1:成为会员消费券比例，2:报单使用消费券比例，3:分红静态比例，4:直推奖比例，5:间推奖比例，6:提现配置
     */
    private Integer configKey;
}

package org.yunxiangxianlu.dal.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("config")
public class ConfigDO {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 配置类型
     */
    private Integer configType;

    /**
     * 配置类型,1:成为会员消费券比例，2:报单使用消费券比例，3:分红静态比例，4:直推奖比例，5:间推奖比例，6:提现配置
     */
    private Integer configKey;

    /**
     * 配置值
     */
    private String configValue;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间（自动更新）
     */
    private LocalDateTime updatedAt;
}

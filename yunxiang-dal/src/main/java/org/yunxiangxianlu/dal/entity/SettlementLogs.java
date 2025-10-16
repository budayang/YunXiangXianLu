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
@TableName("settlement_logs")
public class SettlementLogs {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 结算周期
     */
    private String period;

    /**
     * 结算开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结算结束时间
     */
    private LocalDateTime endTime;

    /**
     * 结算状态：0=进行中，1=完成，2=失败
     */
    private Integer status;

    /**
     * 已处理数量
     */
    private Integer processedCount;

    /**
     * 错误数量
     */
    private Integer errorCount;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}

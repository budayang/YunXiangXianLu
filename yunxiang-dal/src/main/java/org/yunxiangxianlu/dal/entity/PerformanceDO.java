package org.yunxiangxianlu.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("performance")
public class PerformanceDO {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 业绩值（BV/PV）
     */
    private BigDecimal bv;

    /**
     * 计入左区的BV（间接）
     */
    private BigDecimal leftBv;

    /**
     * 计入右区的BV（间接）
     */
    private BigDecimal rightBv;

    /**
     * 结算周期：如 2025-04
     */
    private String period;

    /**
     * 状态：0=待结算，1=已结算
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}

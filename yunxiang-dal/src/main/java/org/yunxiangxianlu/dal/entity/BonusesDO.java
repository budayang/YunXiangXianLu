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
@TableName("bonuses")
public class BonusesDO {

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
     * 奖金类型：1、referral,2、pairing
     */
    private Integer bonusType;

    /**
     * 奖金金额
     */
    private BigDecimal amount;

    /**
     * 来自哪个下级的业绩
     */
    private Long sourceMemberId;

    /**
     * 所属周期
     */
    private String period;

    /**
     * 状态：0=待发放，1=已发放，2=已提现
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}

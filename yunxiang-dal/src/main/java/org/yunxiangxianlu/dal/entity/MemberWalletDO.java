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

/**
 * 会员钱包DO
 * 对应数据库表：member_wallet（存储所有金额型资产）
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("member_wallet")
public class MemberWalletDO {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员ID（关联member表）
     */
    private Long memberId;

    /**
     * 余额（可提现/消费）
     */
    private BigDecimal balance;

    /**
     * 积分金额
     */
    private BigDecimal pointsAmount;

    /**
     * 广告券金额
     */
    private BigDecimal adVoucherAmount;

    /**
     * 代金券金额
     */
    private BigDecimal discountVoucherAmount;

    /**
     * 重消券金额
     */
    private BigDecimal reconsumeVoucherAmount;

    /**
     * 冻结余额状态，0:未冻结，1:冻结
     */
    private Integer frozenStatusBalance;

    /**
     * 冻结积分状态，0:未冻结，1:冻结
     */
    private Integer frozenStatusPointsAmount;

    /**
     * 冻结广告券状态，0:未冻结，1:冻结
     */
    private Integer frozenStatusAdVoucherAmount;

    /**
     * 冻结代金券状态，0:未冻结，1:冻结
     */
    private Integer frozenStatusDiscountVoucherAmount;

    /**
     * 冻结重消券状态，0:未冻结，1:冻结
     */
    private Integer frozenStatusReconsumeVoucherAmount;

    /**
     * 累计总收入
     */
    private BigDecimal totalIncome;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间（自动更新）
     */
    private LocalDateTime updatedAt;
}
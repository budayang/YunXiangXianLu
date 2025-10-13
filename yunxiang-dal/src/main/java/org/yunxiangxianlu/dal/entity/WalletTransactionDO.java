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
 * 钱包流水表DO
 * 对应数据库表：wallet_transaction
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("wallet_transaction")
public class WalletTransactionDO {

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
     * 资产类型：1、balance,2、points,3、ad_voucher,4、discount_voucher,5、reconsume_voucher
     */
    private Integer assetType;

    /**
     * 变动类型：1、increase,2、decrease
     */
    private Integer changeType;

    /**
     * 变动金额（正数）
     */
    private BigDecimal amount;

    /**
     * 冻结金额变动（+为冻结，-为解冻）
     */
    private BigDecimal frozenChange;

    /**
     * 变动后余额（便于对账）
     */
    private BigDecimal balanceAfter;

    /**
     * 变动后积分金额
     */
    private BigDecimal pointsAfter;

    /**
     * 变动后广告券金额
     */
    private BigDecimal adVoucherAfter;

    /**
     * 变动后代金券金额
     */
    private BigDecimal discountVoucherAfter;

    /**
     * 变动后重消券金额
     */
    private BigDecimal reconsumeVoucherAfter;

    /**
     * 业务类型：register_fee, reward, consume, freeze, unfreeze, cashout, reconsume_order 等
     */
    private String tradeType;

    /**
     * 关联ID（如注册订单ID、商品订单ID）
     */
    private Long relatedId;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}
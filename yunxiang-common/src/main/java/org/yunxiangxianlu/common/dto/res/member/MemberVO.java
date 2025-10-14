package org.yunxiangxianlu.common.dto.res.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    /**
     * 会员ID
     */
    private Long id;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号（唯一）
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 当前级别:1、普通会员,2、券商,3、代理,4、股东
     */
    private Integer memberLevel;

    /**
     * 空单身份类型:1、普通会员,2、1000空单会员,3、3000空单会员
     */
    private Integer emptyOrderType;

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
     * 推荐人ID（上级）
     */
    private Long refereeId;

    /**
     * 状态：1-正常，2-冻结，3-注销
     */
    private Integer status;
}

package org.yunxiangxianlu.common.dto.req.member;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberListReq {

    /**
     * 会员姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 会员级别
     */
    private Integer memberLevel;

    /**
     * 空单身份类型
     */
    private Integer emptyOrderType;

    /**
     * 状态
     */
    private Integer status;
}

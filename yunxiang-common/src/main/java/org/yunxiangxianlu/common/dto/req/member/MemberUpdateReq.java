package org.yunxiangxianlu.common.dto.req.member;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateReq {

    /**
     * 会员ID
     */
    @NotNull(message = "会员ID不能为空")
    private Long id;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录密码（bcrypt等加密）
     */
    private String password;

    /**
     * 资金密码（独立加密存储）
     */
    private String fundsPassword;

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
     * 状态：1-正常，2-冻结，3-注销
     */
    private Integer status;
}

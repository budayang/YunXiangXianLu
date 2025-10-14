package org.yunxiangxianlu.common.dto.req.member;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberAddReq {

    /**
     * 登录用户名
     */
    @NotBlank(message = "登录用户名不能为空")
    private String username;

    /**
     * 登录密码（bcrypt等加密）
     */
    @NotBlank(message = "登录密码不能为空")
    private String password;

    /**
     * 资金密码（独立加密存储）
     */
    @NotBlank(message = "资金密码不能为空")
    private String fundsPassword;

    /**
     * 真实姓名
     */
    @NotBlank(message = "真实姓名不能为空")
    private String realName;

    /**
     * 手机号（唯一）
     */
    @NotBlank(message = "手机号不能为空")
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 当前级别:1、普通会员,2、券商,3、代理,4、股东
     */
    @NotNull(message = "会员级别不能为空")
    private Integer memberLevel;

    /**
     * 空单身份类型:1、普通会员,2、1000空单会员,3、3000空单会员
     */
    @NotNull(message = "空单身份类型不能为空")
    private Integer emptyOrderType;

    /**
     * 推荐人ID（上级）
     */
    private Long refereeId;

    /**
     * 状态：1-正常，2-冻结，3-注销
     */
    @NotNull(message = "会员状态不能为空")
    private Integer status;
}

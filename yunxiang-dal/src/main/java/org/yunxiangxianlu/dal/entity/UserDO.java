package org.yunxiangxianlu.dal.entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long created;

    /**
     * 修改时间
     */
    private Long updated;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 修改人
     */
    private Long updater;
}


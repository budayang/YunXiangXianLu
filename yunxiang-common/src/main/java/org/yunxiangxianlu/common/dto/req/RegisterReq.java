package org.yunxiangxianlu.common.dto.req;

import lombok.Data;

@Data
public class RegisterReq {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}

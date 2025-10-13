package org.yunxiangxianlu.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 会员主表DO
 * 对应数据库表：member
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("member")
public class MemberDO {

    /**
     * 会员ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 会员编号（系统生成，如 M20250001）
     */
    private String memberNo;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 登录密码（bcrypt等加密）
     */
    private String passwordHash;

    /**
     * 资金密码（独立加密存储）
     */
    private String fundsPasswordHash;

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
     * 推荐人ID（上级）
     */
    private Long refereeId;

    /**
     * 1、left,2、right
     */
    private Integer placementSide;

    /**
     * 状态：1-正常，2-冻结，3-注销
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
}
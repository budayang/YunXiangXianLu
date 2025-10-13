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
 * 会员推荐关系树DO
 * 对应数据库表：member_tree（支持多级查询）
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("member_tree")
public class MemberTreeDO {

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
     * 上级ID
     */
    private Long ancestorId;

    /**
     * 层级（1=直接上级）
     */
    private Integer distance;

    /**
     * 路径：如 1/3/5
     */
    private String path;

    /**
     * 1、left,2、right
     */
    private Integer placementSide;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
}
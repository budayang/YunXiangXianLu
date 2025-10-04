package org.yunxiangxianlu.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 产品分类DO类
 * 对应数据库表：yunxiangxianlu.product_category
 * 用于与数据库表进行数据交互
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("product_category")
public class ProductCategoryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品分类名称（如：电子产品、服装）
     */
    private String categoryName;

    /**
     * 展示顺序（数字越小越靠前）
     * 默认值为0
     */
    private Integer sortOrder;

    /**
     * 分类图片URL
     */
    private String imageUrl;

    /**
     * 分类描述（备注信息）
     */
    private String comment;

    /**
     * 创建人ID（关联用户表主键）
     */
    private Long created;

    /**
     * 创建时间（时间戳，秒）
     */
    private Long creater;

    /**
     * 更新人ID（关联用户表主键）
     */
    private Long updated;

    /**
     * 更新时间（时间戳，秒）
     */
    private Long updater;
}


package org.yunxiangxianlu.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 产品主信息表（SPU） DO
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("product_spu")
public class ProductSpuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品名称，如：XX品牌洗发水
     */
    private String name;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 状态：1-上架，0-下架
     */
    private Integer status;

    /**
     * 图片url
     */
    private String imageUrl;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 更新时间
     */
    private LocalDateTime updated;

}
package org.yunxiangxianlu.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("product_sku")
public class ProductSkuDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 关联SPU
     */
    private Long spuId;

    /**
     * SKU编码，可自动生成
     */
    private String skuCode;

    /**
     * 规格组合（JSON格式，如：{"容量":"50ml","瓶数":"12瓶","包装":"3盒装"}）
     * 在Java中通常用 Map<String, String> 表示
     */
    private Map<String, String> specifications;

    /**
     * 销售价格（元）
     */
    private BigDecimal price;

    /**
     * 成本价
     */
    private BigDecimal costPrice;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 重量（kg）
     */
    private BigDecimal weight;

    /**
     * SKU主图
     */
    private String imageUrl;

    /**
     * 状态：1-可售，0-缺货/停售
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime created;

    /**
     * 更新时间
     */
    private LocalDateTime updated;

}

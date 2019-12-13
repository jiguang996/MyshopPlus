package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "pms_sku_stock")
public class PmsSkuStock implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    /**
     * sku编码
     */
    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "price")
    private BigDecimal price;

    /**
     * 库存
     */
    @Column(name = "stock")
    private Integer stock;

    /**
     * 预警库存
     */
    @Column(name = "low_stock")
    private Integer lowStock;

    /**
     * 销售属性1
     */
    @Column(name = "sp1")
    private String sp1;

    @Column(name = "sp2")
    private String sp2;

    @Column(name = "sp3")
    private String sp3;

    /**
     * 展示图片
     */
    @Column(name = "pic")
    private String pic;

    /**
     * 销量
     */
    @Column(name = "sale")
    private Integer sale;

    /**
     * 单品促销价格
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 锁定库存
     */
    @Column(name = "lock_stock")
    private Integer lockStock;

    private static final long serialVersionUID = 1L;
}
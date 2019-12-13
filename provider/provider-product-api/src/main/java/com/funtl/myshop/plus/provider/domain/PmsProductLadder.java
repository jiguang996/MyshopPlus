package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "pms_product_ladder")
public class PmsProductLadder implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    /**
     * 满足的商品数量
     */
    @Column(name = "`count`")
    private Integer count;

    /**
     * 折扣
     */
    @Column(name = "discount")
    private BigDecimal discount;

    /**
     * 折后价格
     */
    @Column(name = "price")
    private BigDecimal price;

    private static final long serialVersionUID = 1L;
}
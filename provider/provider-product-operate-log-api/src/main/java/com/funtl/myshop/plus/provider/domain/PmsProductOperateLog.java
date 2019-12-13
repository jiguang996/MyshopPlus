package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "pms_product_operate_log")
public class PmsProductOperateLog implements Serializable {


    private static final long serialVersionUID = -4668766673147202875L;
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "price_old")
    private BigDecimal priceOld;

    @Column(name = "price_new")
    private BigDecimal priceNew;

    @Column(name = "sale_price_old")
    private BigDecimal salePriceOld;

    @Column(name = "sale_price_new")
    private BigDecimal salePriceNew;

    /**
     * 赠送的积分
     */
    @Column(name = "gift_point_old")
    private Integer giftPointOld;

    @Column(name = "gift_point_new")
    private Integer giftPointNew;

    @Column(name = "use_point_limit_old")
    private Integer usePointLimitOld;

    @Column(name = "use_point_limit_new")
    private Integer usePointLimitNew;

    /**
     * 操作人
     */
    @Column(name = "operate_man")
    private String operateMan;

    @Column(name = "create_time")
    private Date createTime;


}
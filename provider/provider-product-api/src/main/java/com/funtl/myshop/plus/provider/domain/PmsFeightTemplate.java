package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "pms_feight_template")
public class PmsFeightTemplate implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "`name`")
    private String name;

    /**
     * 计费类型:0->按重量；1->按件数
     */
    @Column(name = "charge_type")
    private Integer chargeType;

    /**
     * 首重kg
     */
    @Column(name = "first_weight")
    private BigDecimal firstWeight;

    /**
     * 首费（元）
     */
    @Column(name = "first_fee")
    private BigDecimal firstFee;

    @Column(name = "continue_weight")
    private BigDecimal continueWeight;

    @Column(name = "continme_fee")
    private BigDecimal continmeFee;

    /**
     * 目的地（省、市）
     */
    @Column(name = "dest")
    private String dest;

    private static final long serialVersionUID = 1L;
}
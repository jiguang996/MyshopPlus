package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Table(name = "pms_member_price")
public class PmsMemberPrice implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_level_id")
    private Long memberLevelId;

    /**
     * 会员价格
     */
    @Column(name = "member_price")
    private BigDecimal memberPrice;

    @Column(name = "member_level_name")
    private String memberLevelName;

    private static final long serialVersionUID = 1L;
}
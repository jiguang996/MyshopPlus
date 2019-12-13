package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "pms_product_category_attribute_relation")
public class PmsProductCategoryAttributeRelation implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_category_id")
    private Long productCategoryId;

    @Column(name = "product_attribute_id")
    private Long productAttributeId;

    private static final long serialVersionUID = 1L;
}
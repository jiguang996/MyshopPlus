package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "pms_product_category")
public class PmsProductCategory implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 上机分类的编号：0表示一级分类
     */
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "`name`")
    private String name;

    /**
     * 分类级别：0->1级；1->2级
     */
    @Column(name = "`level`")
    private Integer level;

    @Column(name = "product_count")
    private Integer productCount;

    @Column(name = "product_unit")
    private String productUnit;

    /**
     * 是否显示在导航栏：0->不显示；1->显示
     */
    @Column(name = "nav_status")
    private Integer navStatus;

    /**
     * 显示状态：0->不显示；1->显示
     */
    @Column(name = "show_status")
    private Integer showStatus;

    @Column(name = "sort")
    private Integer sort;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    @Column(name = "keywords")
    private String keywords;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    private static final long serialVersionUID = 1L;
}
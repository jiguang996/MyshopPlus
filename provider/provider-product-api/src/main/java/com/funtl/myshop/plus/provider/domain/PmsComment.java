package com.funtl.myshop.plus.provider.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "pms_comment")
public class PmsComment implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "member_nick_name")
    private String memberNickName;

    @Column(name = "product_name")
    private String productName;

    /**
     * 评价星数：0->5
     */
    @Column(name = "star")
    private Integer star;

    /**
     * 评价的ip
     */
    @Column(name = "member_ip")
    private String memberIp;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "show_status")
    private Integer showStatus;

    /**
     * 购买时的商品属性
     */
    @Column(name = "product_attribute")
    private String productAttribute;

    @Column(name = "collect_couont")
    private Integer collectCouont;

    @Column(name = "read_count")
    private Integer readCount;

    @Column(name = "content")
    private String content;

    /**
     * 上传图片地址，以逗号隔开
     */
    @Column(name = "pics")
    private String pics;

    /**
     * 评论用户头像
     */
    @Column(name = "member_icon")
    private String memberIcon;

    @Column(name = "replay_count")
    private Integer replayCount;

    private static final long serialVersionUID = 1L;
}
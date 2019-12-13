package com.funtl.myshop.plus.provider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "pms_product_vertify_record")
public class PmsProductVertifyRecord implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 审核人
     */
    @Column(name = "vertify_man")
    private String vertifyMan;

    @Column(name = "`status`")
    private Integer status;

    /**
     * 反馈详情
     */
    @Column(name = "detail")
    private String detail;

    private static final long serialVersionUID = 1L;
}
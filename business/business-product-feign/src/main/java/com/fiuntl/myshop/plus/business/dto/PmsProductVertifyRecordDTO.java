package com.fiuntl.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PmsProductVertifyRecordDTO implements Serializable {

    private static final long serialVersionUID = -1550868738679530806L;
    private Long id;

    private Long productId;


    private Date createTime;

    /**
     * 审核人
     */
    private String vertifyMan;

    private Integer status;

    /**
     * 反馈详情
     */
    private String detail;


}
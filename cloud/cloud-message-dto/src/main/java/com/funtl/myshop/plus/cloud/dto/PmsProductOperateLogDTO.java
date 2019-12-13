package com.funtl.myshop.plus.cloud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-14 00:41
 * @Version 1.0
 **/
@Data
public class PmsProductOperateLogDTO {

        private static final long serialVersionUID = -6610557341914830628L;
        private Long id;

        private Long productId;

        private BigDecimal priceOld;

        private BigDecimal priceNew;

        private BigDecimal salePriceOld;

        private BigDecimal salePriceNew;

        /**
         * 赠送的积分
         */
        private Integer giftPointOld;

        private Integer giftPointNew;

        private Integer usePointLimitOld;

        private Integer usePointLimitNew;

        /**
         * 操作人
         */
        private String operateMan;

        @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
        private Date createTime;

    }

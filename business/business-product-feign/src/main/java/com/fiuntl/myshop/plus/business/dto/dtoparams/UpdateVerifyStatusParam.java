package com.fiuntl.myshop.plus.business.dto.dtoparams;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-12 20:58
 * @Version 1.0
 **/
@Data
public class UpdateVerifyStatusParam  implements Serializable {

    private static final long serialVersionUID = 7534496521840777950L;

    private Long id;

    private Integer verifyStatus;

    private  String detail;



}

package com.jiguang.myshopplus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 登录信息
 * @Author: GZG
 * @Create: 2019-11-26 11:29
 * @Version 1.0
 **/
@Data
public class LoginInfo  implements Serializable {

    private  String name;
    private  String avatar;


}

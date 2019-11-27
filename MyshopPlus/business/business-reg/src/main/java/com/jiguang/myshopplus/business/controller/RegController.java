package com.jiguang.myshopplus.business.controller;

import com.jiguang.myshopplus.commons.dto.ResponseResult;
import com.jiguang.myshopplus.provider.api.UmsAdminService;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户注册。
 * @Author ji
 * @Date 2019/11/25 14:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "reg")
public class RegController {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    /**
     * 注册
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link ResponseResult}
     */
    @PostMapping(value ="" )
    public ResponseResult<UmsAdmin> reg(@RequestBody UmsAdmin umsAdmin){
        String message=validationReg(umsAdmin);
        //通过验证
        if (message == null) {
            int result = umsAdminService.insert(umsAdmin);

            //注册成功
            if (result >0){
                UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
                return new ResponseResult<UmsAdmin>(HttpStatus.OK.value(),"用户注册成功",admin);
            }
        }

        return new ResponseResult<UmsAdmin>(HttpStatus.NOT_ACCEPTABLE.value(), message != null ? message : "用户注册失败");

    }

    /**
     * 注册用户验证
     * @param umsAdmin {@link UmsAdmin}
     * @return 验证结果
     */
    private String   validationReg(UmsAdmin umsAdmin){
        UmsAdmin admin = umsAdminService.get(umsAdmin.getUsername());
        if (admin != null) {
            return  "用户名已存在或不合法" ;
        }
        return  null;
    }

}

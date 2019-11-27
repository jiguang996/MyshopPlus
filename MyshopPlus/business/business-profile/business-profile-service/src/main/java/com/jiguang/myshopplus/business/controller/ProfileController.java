package com.jiguang.myshopplus.business.controller;

import com.jiguang.myshopplus.business.feign.dto.ProfileParam;
import com.jiguang.myshopplus.commons.dto.ResponseResult;
import com.jiguang.myshopplus.provider.api.UmsAdminService;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 个人信息管理
 * @Author: GZG
 * @Create: 2019-11-26 17:06
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "profile")
public class ProfileController {
    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;
    /**
     * 获取个人信息
     *
     * @param username 用户名
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "info/{username}")
    public ResponseResult<UmsAdmin> info(@PathVariable String username) {
        UmsAdmin umsAdmin = umsAdminService.get(username);
        return new ResponseResult<UmsAdmin>(ResponseResult.CodeStatus.OK, "获取个人信息", umsAdmin);
    }

    /**
     * 更新个人信息
     * @param profileParam
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void>  update(@RequestBody ProfileParam profileParam){
        UmsAdmin umsAdmin=new UmsAdmin();
        BeanUtils.copyProperties(profileParam,umsAdmin);
        int updateResult = umsAdminService.update(umsAdmin);

        //更新成功
        if(updateResult>0){
             return  new ResponseResult<Void>(ResponseResult.CodeStatus.OK,"更新个人信息成功");
        }

        //失败
        else {
            return  new ResponseResult<Void>(ResponseResult.CodeStatus.FAIL,"更新失败");
        }
    }
}



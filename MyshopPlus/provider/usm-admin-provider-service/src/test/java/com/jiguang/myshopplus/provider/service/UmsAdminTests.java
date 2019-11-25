package com.jiguang.myshopplus.provider.service;
import java.util.Date;

import com.jiguang.myshopplus.provider.api.UmsAdminService;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import com.jiguang.myshopplus.provider.mapper.UmsAdminMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author ji
 * @Date 2019/11/24 20:17
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UmsAdminTests {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Resource
    private UmsAdminService umsAdminService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    public  void  testSelectAll(){
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectAll();
        umsAdmins.forEach(umsAdmin -> {
            System.out.println(umsAdmin);
        });
    }

    @Test
    public  void  testInsert(){
        UmsAdmin umsAdmin=new UmsAdmin();
        umsAdmin.setUsername("jiji");
        umsAdmin.setPassword(passwordEncoder.encode("123456"));
        umsAdmin.setIcon("");
        umsAdmin.setEmail("");
        umsAdmin.setNickName("");
        umsAdmin.setNote("");
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        umsAdmin.setStatus(0);


        int result = umsAdminService.insert(umsAdmin);
        Assert.assertEquals(result, 1);
    }
}

package com.jiguang.myshopplus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ji
 * @Date 2019/11/25 17:19
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BusinessOauth2Test {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    public  void  testPasswordEncoder(){
        System.out.println(passwordEncoder.encode("123456"));
    }
}


package com.jiguang.myshopplus.provider.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author ji
 * @Date 2019/11/25 11:41
 * @Version 1.0
 */
@Configuration
public class UmsResourceConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

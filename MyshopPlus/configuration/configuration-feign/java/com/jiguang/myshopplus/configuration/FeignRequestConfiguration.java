package com.jiguang.myshopplus.configuration;

import com.jiguang.myshopplus.interceptor.FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-11-26 22:57
 * @Version 1.0
 **/
@Configuration
public class FeignRequestConfiguration {

    @Bean
    public FeignRequestInterceptor requestInterceptor(){
        return  new FeignRequestInterceptor();
    }
}

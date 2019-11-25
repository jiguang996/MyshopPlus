package com.jiguang.myshopplus.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author ji
 * @Date 2019/11/24 18:52
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jiguang.myshopplus.provider.mapper")
public class UmsAdminProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmsAdminProviderApplication.class, args);
    }
}

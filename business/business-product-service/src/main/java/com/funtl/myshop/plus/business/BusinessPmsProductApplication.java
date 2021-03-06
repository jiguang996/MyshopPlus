package com.funtl.myshop.plus.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BusinessPmsProductApplication {


    public static void main(String[] args) {
        SpringApplication.run(BusinessPmsProductApplication.class, args);
    }

}

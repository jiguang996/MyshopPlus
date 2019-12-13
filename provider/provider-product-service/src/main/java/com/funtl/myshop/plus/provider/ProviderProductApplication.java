package com.funtl.myshop.plus.provider;

import com.funtl.myshop.plus.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author ji
 */
@SpringBootApplication(scanBasePackageClasses = {ProviderProductApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.funtl.myshop.plus.provider.mapper")
public class ProviderProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderProductApplication.class, args);
    }

}

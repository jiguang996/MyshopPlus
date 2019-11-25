package com.jiguang.myshopplus.provider.service;

import com.jiguang.myshopplus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author ji
 * @Date 2019/11/24 18:54
 * @Version 1.0
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String s) {
        return "hello nacos"+s+s;
    }
}

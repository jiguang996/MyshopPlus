package com.jiguang.myshopplus.business.controller;

import com.jiguang.myshopplus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ji
 * @Date 2019/11/24 20:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "echo")
public class EchoController {
    @Reference(version = "1.0.0")
    private EchoService echoService;

    @GetMapping(value = "{s}")
    public  String echo(@PathVariable String s){
        return  echoService.echo(s);
    }
}

package com.funtl.myshop.plus.message;

import com.funtl.myshop.plus.message.sink.ProductOperateLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({ProductOperateLogSink.class})
public class MessageProductOperateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageProductOperateApplication.class, args);
    }

}

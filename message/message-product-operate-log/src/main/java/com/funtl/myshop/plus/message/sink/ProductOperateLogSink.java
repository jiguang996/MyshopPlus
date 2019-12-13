package com.funtl.myshop.plus.message.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProductOperateLogSink {

    @Input("product-operate-log-topic")
    SubscribableChannel productOperateLog();

}

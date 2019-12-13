package com.funtl.myshop.plus.message.consumer;

import com.funtl.myshop.plus.commons.utils.MapperUtils;
import com.funtl.myshop.plus.provider.api.PmsProductOperateLogService;
import com.funtl.myshop.plus.provider.domain.PmsProductOperateLog;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ProductOperateLogReceive {

    @Reference(version = "1.0.0")
    private PmsProductOperateLogService pmsProductOperateLogService;

    @StreamListener("product-operate-log-topic")
    public void receiveProductOperateLog(String productOperateJson) throws Exception {
        PmsProductOperateLog pmsProductOperateLog = MapperUtils.json2pojo(productOperateJson, PmsProductOperateLog.class);
        pmsProductOperateLogService.insert(pmsProductOperateLog);
    }

}

package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.PmsProduct;
import com.funtl.myshop.plus.provider.domain.PmsProductVertifyRecord;

public interface PmsProductVertifyRecordService {

    /**
     * 新增状态码信息
     */
    int create(PmsProductVertifyRecord pmsProductVertifyRecord);
}

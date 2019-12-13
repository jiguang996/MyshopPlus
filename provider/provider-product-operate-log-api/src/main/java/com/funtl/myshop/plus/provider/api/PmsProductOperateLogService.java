package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.PmsProductOperateLog;

public interface PmsProductOperateLogService {

    /**
     * 新增日志
     *
     * @param pmsProductOperateLog {@link PmsProductOperateLog}
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(PmsProductOperateLog pmsProductOperateLog);

}

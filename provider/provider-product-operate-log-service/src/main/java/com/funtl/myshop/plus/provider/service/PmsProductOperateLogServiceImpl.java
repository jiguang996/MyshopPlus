package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.PmsProductOperateLogService;
import com.funtl.myshop.plus.provider.domain.PmsProductOperateLog;
import com.funtl.myshop.plus.provider.mapper.PmsProductOperateLogMapper;

import javax.annotation.Resource;

/**
 * @description:
 * @Author: GZG
 * @Create: 2019-12-14 00:16
 * @Version 1.0
 **/
public class PmsProductOperateLogServiceImpl implements PmsProductOperateLogService {

    @Resource
    private PmsProductOperateLogMapper pmsProductOperateLogMapper;


    @Override
    public int insert(PmsProductOperateLog pmsProductOperateLog) {
        return pmsProductOperateLogMapper.insert(pmsProductOperateLog);
    }
}

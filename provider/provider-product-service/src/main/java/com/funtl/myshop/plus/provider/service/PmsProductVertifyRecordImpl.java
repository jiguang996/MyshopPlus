package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.PmsProductVertifyRecordService;
import com.funtl.myshop.plus.provider.domain.PmsProductVertifyRecord;
import com.funtl.myshop.plus.provider.mapper.PmsProductVertifyRecordMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author ji
 */
@Service(version = "1.0.0")
public class PmsProductVertifyRecordImpl implements PmsProductVertifyRecordService {

    @Resource
    private PmsProductVertifyRecordMapper pmsProductVertifyRecordMapper;
    @Override
    public int create(PmsProductVertifyRecord pmsProductVertifyRecord) {
        return pmsProductVertifyRecordMapper.insert(pmsProductVertifyRecord);
    }
}

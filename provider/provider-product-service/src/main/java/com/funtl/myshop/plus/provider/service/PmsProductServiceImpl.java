package com.funtl.myshop.plus.provider.service;

import com.funtl.myshop.plus.provider.api.PmsProductService;

import com.funtl.myshop.plus.provider.domain.PmsProduct;
import com.funtl.myshop.plus.provider.domain.PmsProductVertifyRecord;
import com.funtl.myshop.plus.provider.mapper.PmsProductMapper;
import com.funtl.myshop.plus.provider.mapper.PmsProductVertifyRecordMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:商品信息 服务实现类
 * @Author: GZG
 * @Create: 2019-12-11 17:18
 * @Version 1.0
 **/
@Service(version = "1.0.0")
public class PmsProductServiceImpl implements PmsProductService {

    @Resource
    private PmsProductMapper pmsProductMapper;

    @Resource
    private PmsProductVertifyRecordMapper pmsProductVertifyRecordMapper;

    @Override
    public List<PmsProduct> getAll() {
        return pmsProductMapper.selectAll();
    }

    @Override
    public int create(PmsProduct pmsProduct) {
        return pmsProductMapper.insert(pmsProduct);
    }



    @Override
    public int update(PmsProduct pmsProduct) {
        PmsProduct oldPmsProduct=getById(pmsProduct.getId());
        BeanUtils.copyProperties(pmsProduct, oldPmsProduct);
        return pmsProductMapper.updateByPrimaryKey(oldPmsProduct);
    }

    @Override
    public int updateVerifyStatus(Long id, Integer verifyStatus, String detail) {
        PmsProduct oldPmsProduct=getById(id);
        oldPmsProduct.setVerifyStatus(verifyStatus);
        int count=pmsProductMapper.updateByPrimaryKey(oldPmsProduct);
        PmsProductVertifyRecord record = new PmsProductVertifyRecord();
        record.setProductId(id);
        record.setCreateTime(new Date());
        record.setDetail(detail);
        record.setStatus(verifyStatus);
        pmsProductVertifyRecordMapper.insert(record);
        return count;
    }

    @Override
    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {

        for (Long id : ids) {
            PmsProduct pmsProduct=getById(id);
            pmsProduct.setPublishStatus(publishStatus);
            pmsProductMapper.updateByPrimaryKey(pmsProduct);
        }
        return ids.size();
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        for (Long id : ids) {
            PmsProduct pmsProduct=getById(id);
            pmsProduct.setPublishStatus(recommendStatus);
            pmsProductMapper.updateByPrimaryKey(pmsProduct);
        }
        return ids.size();
    }

    @Override
    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        for (Long id : ids) {
            PmsProduct pmsProduct=getById(id);
            pmsProduct.setPublishStatus(newStatus);
            pmsProductMapper.updateByPrimaryKey(pmsProduct);
        }
        return ids.size();
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        for (Long id : ids) {
            PmsProduct pmsProduct=getById(id);
            pmsProduct.setPublishStatus(deleteStatus);
            pmsProductMapper.updateByPrimaryKey(pmsProduct);
        }
        return ids.size();
    }

    @Override
    public List<PmsProduct> searchProducts( Map<String,Object>  keywordsMap ) {
        return    pmsProductMapper.searchProducts(keywordsMap);
    }




    @Override
    public PmsProduct getById(Long id) {
        Example example=new Example(PmsProduct.class);
        example.createCriteria().andEqualTo("id", id);
        return pmsProductMapper.selectOneByExample(example);
    }
}

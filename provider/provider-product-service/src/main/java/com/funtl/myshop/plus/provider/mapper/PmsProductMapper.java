package com.funtl.myshop.plus.provider.mapper;

import com.funtl.myshop.plus.provider.domain.PmsProduct;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface PmsProductMapper extends Mapper<PmsProduct> {
    List<PmsProduct> searchProducts(Map<String,Object> keywordsMap);
}
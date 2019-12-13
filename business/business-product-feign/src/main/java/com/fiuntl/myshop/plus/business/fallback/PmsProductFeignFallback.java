package com.fiuntl.myshop.plus.business.fallback;

import com.fiuntl.myshop.plus.business.dto.dtoparams.PmsProductKeywordParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.PmsProductParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.UpdatePmsProductListParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.UpdateVerifyStatusParam;
import com.fiuntl.myshop.plus.business.feign.PmsProductFeign;

import org.springframework.stereotype.Component;

/**
 * 个人信息服务熔断器
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-27 23:50:08
 * @see com.funtl.myshop.plus.business.feign.fallback
 */
@Component
public class PmsProductFeignFallback implements PmsProductFeign {

    public static final String BREAKING_MESSAGE = "请求失败了，请检查您的网络";


    @Override
    public String createProduct(PmsProductParam pmsProductParam) {
        return null;
    }

    @Override
    public String getProductInfo(Long id) {
        return null;
    }

    @Override
    public String updateProduct(PmsProductParam pmsProductParam) {
        return null;
    }

    @Override
    public String getByVerifyStatus(Integer verifyStatus) {
        return null;
    }

    @Override
    public String getByPublishStatus(Integer publishStatus) {
        return null;
    }

    @Override
    public String getByProductCategoryName(String productCategoryName) {
        return null;
    }

    @Override
    public String getByBrandName(String brandName) {
        return null;
    }

    @Override
    public String getByProductSn(String productSn) {
        return null;
    }

    @Override
    public String getByProductName(String productName) {
        return null;
    }

    @Override
    public String searchProducts(PmsProductKeywordParam pmsProductKeywordParam) {
        return null;
    }

    @Override
    public String getAllProducts() {
        return null;
    }



    @Override
    public String updateDeleteStatus(UpdatePmsProductListParam UpdatePmsProductListParam) {
        return null;
    }

    @Override
    public String updateVerifyStatus(UpdateVerifyStatusParam updateVerifyStatusParam) {
        return null;
    }

    @Override
    public String updatePublishStatus(UpdatePmsProductListParam UpdatePmsProductListParam) {
        return null;
    }

    @Override
    public String updateRecommendStatus(UpdatePmsProductListParam UpdatePmsProductListParam) {
        return null;
    }

    @Override
    public String updateNewStatus(UpdatePmsProductListParam UpdatePmsProductListParam) {
        return null;
    }
}

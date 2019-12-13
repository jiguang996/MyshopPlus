package com.funtl.myshop.plus.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fiuntl.myshop.plus.business.dto.PmsProductDTO;
import com.fiuntl.myshop.plus.business.dto.dtoparams.PmsProductKeywordParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.PmsProductParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.UpdatePmsProductListParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.UpdateVerifyStatusParam;
import com.funtl.myshop.plus.business.fallback.PmsProductControllerFallback;
import com.funtl.myshop.plus.business.utils.UserUtils;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import com.funtl.myshop.plus.provider.api.PmsProductService;
import com.funtl.myshop.plus.provider.api.PmsProductVertifyRecordService;
import com.funtl.myshop.plus.provider.domain.PmsProduct;
import com.funtl.myshop.plus.provider.domain.PmsProductVertifyRecord;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 个人信息管理
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-30 22:34:41
 * @see com.funtl.myshop.plus.business.controller
 */
@RestController
@RequestMapping(value = "product")
public class PmsProductController {

    @Reference(version = "1.0.0")
    private PmsProductService pmsProductService;

    @Reference(version = "1.0.0")
    private PmsProductVertifyRecordService pmsProductVertifyRecordService;

    /**
     * 获取商品信息
     *
     * @param id {@code Long} id
     * @return {@link ResponseResult}
     */
    @GetMapping(value = "info/{id}")
    @SentinelResource(value = "info", fallback = "infoFallback", fallbackClass = PmsProductControllerFallback.class)
    public ResponseResult<PmsProductDTO> getProductInfo(@PathVariable Long id) {
        PmsProduct pmsProduct = pmsProductService.getById(id);
        PmsProductDTO dto = new PmsProductDTO();
        BeanUtils.copyProperties(pmsProduct, dto);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "获取商品信息", dto);
    }

    /**
     * 查询所有商品
     *
     * @return
     */
    @GetMapping(value = "products")
    public ResponseResult<List<PmsProductDTO>> getAllProducts() {
        List<PmsProduct> pmsProductList = pmsProductService.getAll();
        List<PmsProductDTO> pmsProductDTOList = new ArrayList<>();
        for (PmsProduct pmsProduct : pmsProductList) {
            PmsProductDTO dto = new PmsProductDTO();
            BeanUtils.copyProperties(pmsProduct, dto);
            pmsProductDTOList.add(dto);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "查询所有用户", pmsProductDTOList);
    }

    /**
     * 新增商品
     *
     * @param pmsProductParam
     * @return
     */
    @GetMapping(value = "insert")
    public ResponseResult<Void> createProduct(@RequestBody PmsProductParam pmsProductParam) {
        PmsProduct pmsProduct = new PmsProduct();
        BeanUtils.copyProperties(pmsProductParam, pmsProduct);
        int result = pmsProductService.create(pmsProduct);
        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "新增商品成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "新增商品失败");
        }
    }

    /**
     * 更新商品信息
     *
     * @param pmsProductParam {@link PmsProductParam}
     * @return {@link ResponseResult}
     */

    @PostMapping(value = "update/product")
    public ResponseResult<Void> updateProduct(@RequestBody PmsProductParam pmsProductParam) {
        PmsProduct pmsProduct = new PmsProduct();
        BeanUtils.copyProperties(pmsProductParam, pmsProduct);
        int result = pmsProductService.update(pmsProduct);

        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "更新商品信息成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "更新商品信息失败");
        }
    }

    /**
     * 批量删除商品
     *
     * @param updatePmsProductListParam
     * @return
     */
    @PostMapping(value = "update/deletestatus")
    public ResponseResult<Void> updateDeleteStatus(@RequestBody UpdatePmsProductListParam updatePmsProductListParam) {
        List<Long> ids = updatePmsProductListParam.getIds();
        int result = pmsProductService.updateDeleteStatus(ids, updatePmsProductListParam.getDeleteStatus());
        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "批量删除商品成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "批量删除商品失败");
        }
    }

    /**
     * 批量修改商品上架状态
     *
     * @param updatePmsProductListParam
     * @return
     */
    @PostMapping(value = "update/publishstatus")
    public ResponseResult<Void> updatePublishStatus(@RequestBody UpdatePmsProductListParam updatePmsProductListParam) {
        List<Long> ids = updatePmsProductListParam.getIds();
        int result = pmsProductService.updatePublishStatus(ids, updatePmsProductListParam.getPublishStatus());
        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "批量修改商品上架状态成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "批量修改商品上架状态失败");
        }
    }

    /**
     * 批量修改推荐状态
     *
     * @param updatePmsProductListParam
     * @return
     */
    @PostMapping(value = "update/recommendstatus")
    public ResponseResult<Void> updateRecommendStatus(@RequestBody UpdatePmsProductListParam updatePmsProductListParam) {
        List<Long> ids = updatePmsProductListParam.getIds();
        int result = pmsProductService.updateRecommendStatus(ids, updatePmsProductListParam.getRecommendStatus());
        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "批量修改推荐状态成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "批量修改推荐状态失败");
        }
    }

    /**
     * 批量修改新品状态
     *
     * @param updatePmsProductListParam
     * @return
     */
    @PostMapping(value = "update/newstatus")
    public ResponseResult<Void> updateNewStatus(@RequestBody UpdatePmsProductListParam updatePmsProductListParam) {
        List<Long> ids = updatePmsProductListParam.getIds();
        int result = pmsProductService.updateNewStatus(ids, updatePmsProductListParam.getNewStatus());
        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "批量修改新品状态成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "批量修改新品状态失败");
        }
    }

    /**
     * 修改审核状态
     *
     * @param updateVerifyStatusParam 更新状态码的参数
     */
    @PostMapping(value = "update/verifystatus")
    public ResponseResult<Void> updateVerifyStatus(@RequestBody UpdateVerifyStatusParam updateVerifyStatusParam) {
        PmsProduct pmsProduct = pmsProductService.getById(updateVerifyStatusParam.getId());
        pmsProduct.setVerifyStatus(updateVerifyStatusParam.getVerifyStatus());
        PmsProductVertifyRecord record = new PmsProductVertifyRecord();
        record.setProductId(updateVerifyStatusParam.getId());
        record.setCreateTime(new Date());
        record.setDetail(updateVerifyStatusParam.getDetail());
        record.setStatus(updateVerifyStatusParam.getVerifyStatus());
        record.setVertifyMan(UserUtils.getCurrentUser().getUsername());

        int result = pmsProductVertifyRecordService.create(record);
        // 成功
        if (result > 0) {
            return new ResponseResult<>(ResponseResult.CodeStatus.OK, "修改审核状态成功");
        }

        // 失败
        else {
            return new ResponseResult<>(ResponseResult.CodeStatus.FAIL, "修改审核状态失败");
        }
    }

    /**
     * 搜索用户
     *
     * @param keywords {@link PmsProductKeywordParam}
     * @return {@link ResponseResult}
     */


    @PostMapping(value = "search")
    public ResponseResult<List<PmsProductDTO>> search(@RequestBody PmsProductKeywordParam keywords) {
        Map<String,Object> keywordsMap=new HashMap<>();
        keywordsMap.put("productName",keywords.getProductName());
        keywordsMap.put("productSn",keywords.getProductSn());
        keywordsMap.put("productCategoryName",keywords.getProductCategoryName());
        keywordsMap.put("publishStatus",keywords.getPublishStatus());
        keywordsMap.put("brandName",keywords.getBrandName());
        keywordsMap.put("verifyStatus",keywords.getVerifyStatus());
        List<PmsProductDTO> pmsProductDTOList = new ArrayList<>();
        List<PmsProduct> pmsProductList = pmsProductService.searchProducts(keywordsMap);
        for (PmsProduct pmsProduct : pmsProductList) {
            PmsProductDTO pmsProductDTO = new PmsProductDTO();
            BeanUtils.copyProperties(pmsProduct, pmsProductDTO);
            pmsProductDTOList.add(pmsProductDTO);
        }
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "搜索用户", pmsProductDTOList);

    }

}
package com.fiuntl.myshop.plus.business.feign;

import com.fiuntl.myshop.plus.business.dto.dtoparams.PmsProductKeywordParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.PmsProductParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.UpdatePmsProductListParam;
import com.fiuntl.myshop.plus.business.dto.dtoparams.UpdateVerifyStatusParam;
import com.fiuntl.myshop.plus.business.fallback.PmsProductFeignFallback;
import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 个人信息管理
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-31 00:47:14
 * @see com.funtl.myshop.plus.business.feign
 */
@FeignClient(value = "business-product", path = "product", configuration = FeignRequestConfiguration.class, fallback = PmsProductFeignFallback.class)
public interface PmsProductFeign {


    /**
     * 新增商品
     * @param pmsProductParam
     * @return
     */
    @GetMapping(value = "insert")
    String createProduct(@RequestBody PmsProductParam pmsProductParam);

    /**
     * 获取商品信息
     *
     * @param id {@code String} id
     * @return {@code String} JSON
     */
    @GetMapping(value = "info/{id}")
    String getProductInfo(@PathVariable Long  id);

    /**
     * 更新商品信息
     * @param pmsProductParam {@link PmsProductParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "update/product")
    String updateProduct(@RequestBody PmsProductParam pmsProductParam);


    /**
     * 根据审核状态查询用户
     *
     * @param verifyStatus 审核状态码 ：0->未审核；1->审核通过
     * @return {@code String} JSON
     */

    String getByVerifyStatus( Integer verifyStatus);

    /**
     * 根据上架状态查询用户
     *
     * @param publishStatus 上架状态 ：0->下架；1->上架
     * @return {@code String} JSON
     */
    String getByPublishStatus(Integer publishStatus);

    /**
     * 根据商品分类查询用户
     *
     * @param productCategoryName 商品分类
     * @return {@code String} JSON
     */
    String getByProductCategoryName(String productCategoryName);

    /**
     * 根据商品品牌查询用户
     *
     * @param brandName 商品品牌
     * @return {@code String} JSON
     */
    String getByBrandName(String brandName);

    /**
     * 根据商品货号查询用户
     *
     * @param productSn 商品货号
     * @return {@code String} JSON
     */
    String getByProductSn(String productSn);


    /**
     * 根据商品名称查询用户
     *
     * @param productName 商品名称
     * @return {@code String} JSON
     */
    String getByProductName(String productName);

    /**
     * 搜索商品
     * @param pmsProductKeywordParam
     * @return
     */
    @PostMapping(value = "search/products")
    String searchProducts(@RequestBody PmsProductKeywordParam pmsProductKeywordParam);

    /**
     * 查询所有商品
     * @return
     */
    @GetMapping(value = "products")
    String getAllProducts();

    /**
     * 批量删除商品
     * @param UpdatePmsProductListParam
     * @return
     */
    @PostMapping(value = "update/deletestatus")
    String updateDeleteStatus(@RequestBody UpdatePmsProductListParam UpdatePmsProductListParam);


    /**
     * 修改审核状态
     *
     * @param  updateVerifyStatusParam 更新状态码的参数
     */
    @PostMapping(value = "update/verifystatus")
    String updateVerifyStatus(@RequestBody UpdateVerifyStatusParam updateVerifyStatusParam);


    /**
     * 批量修改商品上架状态
     *  @param UpdatePmsProductListParam
     */
    @PostMapping(value = "update/publishstatus")
    String updatePublishStatus(@RequestBody UpdatePmsProductListParam UpdatePmsProductListParam);

    /**
     * 批量修改推荐状态
     *  @param UpdatePmsProductListParam
     */
    @PostMapping(value = "update/recommendstatus")
    String updateRecommendStatus(@RequestBody UpdatePmsProductListParam UpdatePmsProductListParam);


    /**
     * 批量修改新品状态
     *  @param UpdatePmsProductListParam
     */
    @PostMapping(value = "update/newstatus")
    String updateNewStatus(@RequestBody UpdatePmsProductListParam UpdatePmsProductListParam);



}

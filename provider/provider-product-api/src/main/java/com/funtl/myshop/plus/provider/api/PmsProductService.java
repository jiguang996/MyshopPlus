package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.PmsProduct;
import com.funtl.myshop.plus.provider.domain.PmsProductVertifyRecord;

import java.util.List;
import java.util.Map;

/**
 *商品信息服务实现
 * @Author ji
 * @Date 2019/12/11 16:47
 * @Version 1.0
 */
public interface PmsProductService {
    /**
     * 查询所有商品信息
     * @return
     */
    List<PmsProduct> getAll();

    /**
     * 新增商品
     * @param pmsProduct
     * @return
     */
    int create(PmsProduct pmsProduct);



    /**
     * 更新商品
     */
    int update(PmsProduct pmsProduct);

    /**
     * 批量修改审核状态
     *
     * @param id        产品id
     * @param verifyStatus 审核状态
     * @param detail       审核详情
     */

    int updateVerifyStatus(Long id, Integer verifyStatus, String detail);

    /**
     * 批量修改商品上架状态
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * 批量修改商品推荐状态
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * 批量修改新品状态
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * 批量删除商品
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * 根据商品名称或者货号模糊查询
     */
    List<PmsProduct> searchProducts(Map<String,Object> keywordsMap);


    /**
     * 通过id查找商品
     * @param id
     * @return
     */
    PmsProduct getById(Long id );
}

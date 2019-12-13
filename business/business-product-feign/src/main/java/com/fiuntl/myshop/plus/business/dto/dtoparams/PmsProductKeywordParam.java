package com.fiuntl.myshop.plus.business.dto.dtoparams;

import lombok.Data;

import java.io.Serializable;

/**
 * 修改头像参数
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-26 23:44:42
 * @see com.funtl.myshop.plus.business.dto
 */
@Data
public class PmsProductKeywordParam implements Serializable {

    private static final long serialVersionUID = -7728774853498686387L;
    /**
     * 关键词_商品名称
     */
    private String productName;

    /**
     * 关键词_商品货号
     */
    private String productSn;

    /**
     * 关键词_商品分类
     */
    private String productCategoryName;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 上架状态：0->下架；1->上架
     */
    private Integer publishStatus;


    /**
     * 审核状态：0->未审核；1->审核通过
     */
    private Integer verifyStatus;



}

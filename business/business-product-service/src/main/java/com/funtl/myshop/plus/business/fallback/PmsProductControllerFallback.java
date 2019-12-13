package com.funtl.myshop.plus.business.fallback;

import com.fiuntl.myshop.plus.business.dto.PmsProductDTO;
import com.fiuntl.myshop.plus.business.fallback.PmsProductFeignFallback;
import com.funtl.myshop.plus.commons.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户管理服务熔断器
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-08-31 02:18:32
 * @see com.funtl.myshop.plus.business.controller.fallback
 */
public class PmsProductControllerFallback {

    private static final Logger logger = LoggerFactory.getLogger(PmsProductControllerFallback.class);

    /**
     * 熔断方法
     *
     * @param name {@code String} 用户名
     * @return {@link ResponseResult<PmsProductDTO>}
     */
    public static ResponseResult<PmsProductDTO> infoFallback(String name, Throwable ex) {
        logger.warn("Invoke infoFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return new ResponseResult<PmsProductDTO>(ResponseResult.CodeStatus.BREAKING, PmsProductFeignFallback.BREAKING_MESSAGE);
    }

}

package com.funtl.myshop.plus.business.controller.fallback;

import com.funtl.myshop.plus.business.dto.UmsAdminDTO;
import com.funtl.myshop.plus.business.feign.fallback.UserFeignFallback;
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
public class UserControllerFallback {

    private static final Logger logger = LoggerFactory.getLogger(UserControllerFallback.class);

    /**
     * 熔断方法
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult<UmsAdminDTO>}
     */
    public static ResponseResult<UmsAdminDTO> infoFallback(String username, Throwable ex) {
        logger.warn("Invoke infoFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return new ResponseResult<UmsAdminDTO>(ResponseResult.CodeStatus.BREAKING, UserFeignFallback.BREAKING_MESSAGE);
    }

}

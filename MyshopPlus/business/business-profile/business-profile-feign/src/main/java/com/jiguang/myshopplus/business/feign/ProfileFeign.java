package com.jiguang.myshopplus.business.feign;

import com.jiguang.myshopplus.business.feign.dto.ProfileParam;
import com.jiguang.myshopplus.configuration.FeignRequestConfiguration;
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
 */
@FeignClient(value = "business-profile", path = "profile",configuration = FeignRequestConfiguration.class )
public interface ProfileFeign {
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);

    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

}

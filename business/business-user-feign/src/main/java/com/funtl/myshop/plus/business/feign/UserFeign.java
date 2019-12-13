package com.funtl.myshop.plus.business.feign;

import com.funtl.myshop.plus.business.dto.params.IconParam;
import com.funtl.myshop.plus.business.dto.params.KeywordParam;
import com.funtl.myshop.plus.business.dto.params.PasswordParam;
import com.funtl.myshop.plus.business.dto.params.ProfileParam;
import com.funtl.myshop.plus.business.feign.fallback.UserFeignFallback;
import com.funtl.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
@FeignClient(value = "business-user", path = "user", configuration = FeignRequestConfiguration.class, fallback = UserFeignFallback.class)
public interface UserFeign {

    /**
     * 获取个人信息
     *
     * @param username {@code String} 用户名
     * @return {@code String} JSON
     */
    @GetMapping(value = "info/{username}")
    String info(@PathVariable String username);

    /**
     * 更新个人信息
     *
     * @param profileParam {@link ProfileParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "update")
    String update(@RequestBody ProfileParam profileParam);

    /**
     * 修改密码
     *
     * @param passwordParam {@link PasswordParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "modify/password")
    String modifyPassword(@RequestBody PasswordParam passwordParam);

    /**
     * 修改头像
     *
     * @param iconParam {@link IconParam}
     * @return {@code String} JSON
     */
    @PostMapping(value = "modify/icon")
    String modifyIcon(@RequestBody IconParam iconParam);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return {@code String} JSON
     */

    String getByUsername(@PathVariable String username);

    /**
     * 根据邮箱查询用户
     *
     * @param email 用户名
     * @return {@code String} JSON
     */
    String getByEmail(String email);

    /**
     * 根据OpenId查询用户
     *
     * @param OpenId 用户名
     * @return {@code String} JSON
     */
    String getByOpenId(String OpenId);

    /**
     * 搜索用户
     * @param keywordParam
     * @return
     */
    @PostMapping(value = "search")
    String search(@RequestBody KeywordParam keywordParam);
    /**
     * 查询所有用户
     * @return
     */
    @GetMapping(value = "userlist")
    String userlist();

    /**
     * 删除用户
     * @param profileParam
     * @return
     */
    @PostMapping(value = "delete/user")
    String deleteUser(@RequestBody ProfileParam profileParam);
}

package com.funtl.myshop.plus.provider.api;

import com.funtl.myshop.plus.provider.domain.UmsAdmin;

import java.util.List;

/**
 * 用户管理服务
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-07-26 09:32:31
 * @see com.funtl.myshop.plus.provider.api
 */
public interface UmsAdminService {

    /**
     * 新增用户
     *
     * @param umsAdmin {@link UmsAdmin}
     * @return {@code int} 大于 0 则表示添加成功
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin getByUsername(String username);

    /**
     * 根据用户名查询用户
     *
     * @param email 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin getByEmail(String email);

    /**
     * 根据OpenId查询用户
     *
     * @param OpenId 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin getByOpenId(String OpenId);

    /**
     * 根据用户昵称查询用户
     *
     * @param nickname 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin getByNickname(String nickname);

    /**
     * 获取所有用户
     * @return
     */
    List<UmsAdmin>  getAllUsers();

    /**
     * 获取用户
     *
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     * 更新用户
     * <p>
     * 仅允许更新 邮箱、昵称、备注、状态
     * </p>
     *
     * @param umsAdmin {@link UmsAdmin}
     * @return {@code int} 大于 0 则表示更新成功
     */
    int update(UmsAdmin umsAdmin);

    /**
     * 修改密码
     *
     * @param username {@code String} 用户名
     * @param password {@code String} 明文密码
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyPassword(String username, String password);

    /**
     * 修改头像
     *
     * @param username {@code String} 用户名
     * @param path     {@code String} 头像地址
     * @return {@code int} 大于 0 则表示更新成功
     */
    int modifyIcon(String username, String path);

    /**
     * 删除用户
     * @param username
     * @return{@code int} 大于 0 则表示删除成功
     */
    int deleteUser(String username);
}

package com.jiguang.myshopplus.provider.api;

import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;

/**
 * @Author ji
 * @Date 2019/11/25 11:13
 * @Version 1.0
 */
public interface UmsAdminService {
    /**
     * 新增用户
     * @param umsAdmin {@link UmsAdmin}
     * @return 大于0 则表示添加成功
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 获取用户
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(String username);

    /**
     * 获取用户
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link UmsAdmin}
     */
    UmsAdmin get(UmsAdmin umsAdmin);

    /**
     * 更新用户
     * @param umsAdmin {@link UmsAdmin}
     * @return {@link UmsAdmin}
     */
    int update(UmsAdmin umsAdmin);
}


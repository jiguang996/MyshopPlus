package com.jiguang.myshopplus.business.service;

import com.google.common.collect.Lists;
import com.jiguang.myshopplus.provider.api.UmsAdminService;
import com.jiguang.myshopplus.provider.api.domain.UmsAdmin;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author ji
 * @Date 2019/11/25 17:13
 * @Version 1.0
 */
@Component
public class UserDetailServiceImpl  implements UserDetailsService {

    @Reference(version = "1.0.0")
    private UmsAdminService umsAdminService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //给与用户权限
        List<GrantedAuthority> grantedAuthorities= Lists.newArrayList();
        GrantedAuthority grantedAuthority=new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(grantedAuthority);
        UmsAdmin umsAdmin = umsAdminService.get(s);

        //账号存在
        if (umsAdmin != null) {
                return  new User(umsAdmin.getUsername(), umsAdmin.getPassword(), grantedAuthorities);
        }

        //账号不存在
        else {
            return  null;
        }

    }
}

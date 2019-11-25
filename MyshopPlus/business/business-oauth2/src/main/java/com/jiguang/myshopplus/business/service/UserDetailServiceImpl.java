package com.jiguang.myshopplus.business.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
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

    private  static final  String USERNAME="admin";
    private  static  final  String PASSWORD="$2a$10$v55CrrePU77dI2YEmk.aNukiOXZDpzLKqUMEmyaeUQvVvf5EGRMXC";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities= Lists.newArrayList();
        return new User(USERNAME, PASSWORD, grantedAuthorities);
    }
}
